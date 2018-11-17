package com.mursitaffandi.footballclub.club

import com.mursitaffandi.footballclub.entity.team.Team

/**
 * Created by mursitaffandi on 7/29/18.
 */
interface ClubsView {
    fun showClubs(data: List<Team>)
    fun showProgress()
    fun hideProgress()
}