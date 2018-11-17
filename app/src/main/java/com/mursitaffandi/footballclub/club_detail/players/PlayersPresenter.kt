package com.mursitaffandi.footballclub.club_detail.players

import android.content.Context
import com.google.gson.Gson
import com.mursitaffandi.footballclub.api.ApiRepository
import com.mursitaffandi.footballclub.api.TheSportDBApi
import com.mursitaffandi.footballclub.club_detail.TeamDetailView
import com.mursitaffandi.footballclub.entity.team.player.TeamPlayer
import com.mursitaffandi.footballclub.util.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

/**
 * Created by mursitaffandi on 7/29/18.
 */
class PlayersPresenter(private val view: PlayersView,
                       private val apiRepository: ApiRepository,
                       private val gson: Gson, private val ctx: CoroutineContextProvider = CoroutineContextProvider()) {
    fun loadPlayer(teamId:String){
        val type:String = TheSportDBApi.getPlayerTeam(teamId)

        async(ctx.main){
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(type),
                        TeamPlayer::class.java)
            }
            view.showPlayer(data.await().player)
        }
    }
}