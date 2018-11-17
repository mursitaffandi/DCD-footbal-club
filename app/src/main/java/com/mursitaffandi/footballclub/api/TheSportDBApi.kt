package com.mursitaffandi.footballclub.api

import com.mursitaffandi.footballclub.BuildConfig

/**
 * Created by mursitaffandi on 7/20/18.
 */
object TheSportDBApi {
    fun getEventsnextleague(id : String): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventsnextleague.php?id=" + id
    }

    fun getEventspastleague(id : String):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventspastleague.php?id=" + id
    }

    fun getLookupTeam(id : String) :String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupteam.php?id=" + id
    }

    fun getTeamsFromLeague(id : String) :String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookup_all_teams.php?id=" + id
    }


    fun getPlayerTeam(teamId: String?): String {
        return BuildConfig.BASE_URL +
                "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookup_all_players.php?id=" + teamId
    }

    fun getPlayerDetail(playerId: String?): String {
        return BuildConfig.BASE_URL +
                "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupplayer.php?id=" + playerId
    }

    fun getSearchMatch(searchInput: String?): String {
        return BuildConfig.BASE_URL +
                "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/searchevents.php?e=" + searchInput
    }

    fun getSearchTeam(searchInput: String?): String {
        return BuildConfig.BASE_URL +
                "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/searchteams.php?t=" + searchInput
    }

}