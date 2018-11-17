package com.mursitaffandi.footballclub.schedule_detail

import com.mursitaffandi.footballclub.entity.team.Team


/**
 * Created by mursitaffandi on 7/26/18.
 */
interface MatchDetailView {
    fun showSnackbar(msg: String)
    fun showTeam(team : Team)
}