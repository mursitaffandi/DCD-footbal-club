package com.mursitaffandi.footballclub.club_detail.players

import com.mursitaffandi.footballclub.entity.team.player.Player

/**
 * Created by mursitaffandi on 7/29/18.
 */
interface PlayersView {
    fun showPlayer(player: List<Player>)
}