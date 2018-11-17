package com.mursitaffandi.footballclub.schedule

import android.content.Context
import com.google.gson.Gson
import com.mursitaffandi.footballclub.api.ApiRepository
import com.mursitaffandi.footballclub.api.TheSportDBApi
import com.mursitaffandi.footballclub.entity.match.Match
import com.mursitaffandi.footballclub.entity.match.ScheduleLeague
import com.mursitaffandi.footballclub.helper.database
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import com.mursitaffandi.footballclub.util.CoroutineContextProvider



/**
 * Created by mursitaffandi on 7/20/18.
 */
class SchedulePresenter(private val view: ScheduleView,
                        private val apiRepository: ApiRepository,
                        private val gson: Gson, private val context: Context, private val ctx: CoroutineContextProvider = CoroutineContextProvider()){

    fun getSchedule(typeSchedule : Int, idLeague: String="", keySearch:String="") {
        val type:String
        when(typeSchedule){
            0 -> type = TheSportDBApi.getEventsnextleague(idLeague)
            1 -> type = TheSportDBApi.getEventspastleague(idLeague)
            3 -> type = TheSportDBApi.getSearchMatch(keySearch)
            else -> {
                getSchedule()
                return
            }
        }
        async(ctx.main){
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(type),
                        ScheduleLeague::class.java)
            }
            view.showSchedule(data.await().matches)
        }
    }

    private fun getSchedule(){
        context.database.use {
            val result = select(Match.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<Match>())
            view.showSchedule(favorite)
        }
    }
}