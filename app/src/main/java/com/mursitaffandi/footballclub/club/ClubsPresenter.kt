package com.mursitaffandi.footballclub.club

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.mursitaffandi.footballclub.api.ApiRepository
import com.mursitaffandi.footballclub.api.TheSportDBApi
import com.mursitaffandi.footballclub.entity.team.Team
import com.mursitaffandi.footballclub.entity.team.TeamsLeague
import com.mursitaffandi.footballclub.helper.database
import com.mursitaffandi.footballclub.util.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

/**
 * Created by mursitaffandi on 7/29/18.
 */
class ClubsPresenter(private val view: ClubsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson, private val context: Context, private val ctx: CoroutineContextProvider = CoroutineContextProvider()) {
private lateinit var keyword : String

    fun getClubs(legueID: String = "a", keySearch: String = "") {
        val type: String
        keyword=keySearch
        when (legueID) {
            "a" -> {
                    getClubs();return
            }
            else -> {
                type = if (keySearch.equals("")) TheSportDBApi.getTeamsFromLeague(legueID) else TheSportDBApi.getSearchTeam(keySearch)
            }
        }

        async(ctx.main) {
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(type),
                        TeamsLeague::class.java)
            }
            view.showClubs(data.await().teams)
        }
    }

    private fun getClubs() {
        when(keyword){
            "" -> { context.database.use {
                val result = select(Team.TABLE_FAVORITE_TEAM)
                val favorite = result.parseList(classParser<Team>())
                view.showClubs(favorite)
            }}
            else ->{
                getClubs("b",keyword);return
            }
        }

    }
}