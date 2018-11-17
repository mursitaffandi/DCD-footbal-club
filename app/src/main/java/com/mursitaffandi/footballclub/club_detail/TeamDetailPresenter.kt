package com.mursitaffandi.footballclub.club_detail

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import com.google.gson.Gson
import com.mursitaffandi.footballclub.api.ApiRepository
import com.mursitaffandi.footballclub.api.TheSportDBApi
import com.mursitaffandi.footballclub.entity.match.Match
import com.mursitaffandi.footballclub.entity.team.Team
import com.mursitaffandi.footballclub.entity.team.player.TeamPlayer
import com.mursitaffandi.footballclub.helper.database
import com.mursitaffandi.footballclub.util.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by mursitaffandi on 7/29/18.
 */
class TeamDetailPresenter(private val view: TeamDetailView,private val detailTeam: Team,
                          private val ctx: TeamDetailActivity) {

    fun addToFavorite() {
        try {
            ctx.database.use {
                insert(Team.TABLE_FAVORITE_TEAM,
                        Team.IDTEAM to detailTeam.idTeam,
                        Team.IDSOCCERXML to detailTeam.idSoccerXML,
                        Team.INTLOVED to detailTeam.intLoved,
                        Team.STRTEAM to detailTeam.strTeam,
                        Team.STRTEAMSHORT to detailTeam.strTeamShort,
                        Team.STRALTERNATE to detailTeam.strAlternate,
                        Team.INTFORMEDYEAR to detailTeam.intFormedYear,
                        Team.STRSPORT to detailTeam.strSport,
                        Team.STRLEAGUE to detailTeam.strLeague,
                        Team.IDLEAGUE to detailTeam.idLeague,
                        Team.STRDIVISION to detailTeam.strDivision,
                        Team.STRMANAGER to detailTeam.strManager,
                        Team.STRSTADIUM to detailTeam.strStadium,
                        Team.STRKEYWORDS to detailTeam.strKeywords,
                        Team.STRRSS to detailTeam.strRSS,
                        Team.STRSTADIUMTHUMB to detailTeam.strStadiumThumb,
                        Team.STRSTADIUMDESCRIPTION to detailTeam.strStadiumDescription,
                        Team.STRSTADIUMLOCATION to detailTeam.strStadiumLocation,
                        Team.INTSTADIUMCAPACITY to detailTeam.intStadiumCapacity,
                        Team.STRWEBSITE to detailTeam.strWebsite,
                        Team.STRFACEBOOK to detailTeam.strFacebook,
                        Team.STRTWITTER to detailTeam.strTwitter,
                        Team.STRINSTAGRAM to detailTeam.strInstagram,
                        Team.STRDESCRIPTIONEN to detailTeam.strDescriptionEN,
                        Team.STRDESCRIPTIONDE to detailTeam.strDescriptionDE,
                        Team.STRDESCRIPTIONFR to detailTeam.strDescriptionFR,
                        Team.STRDESCRIPTIONCN to detailTeam.strDescriptionCN,
                        Team.STRDESCRIPTIONIT to detailTeam.strDescriptionIT,
                        Team.STRDESCRIPTIONJP to detailTeam.strDescriptionJP,
                        Team.STRDESCRIPTIONRU to detailTeam.strDescriptionRU,
                        Team.STRDESCRIPTIONES to detailTeam.strDescriptionES,
                        Team.STRDESCRIPTIONPT to detailTeam.strDescriptionPT,
                        Team.STRDESCRIPTIONSE to detailTeam.strDescriptionSE,
                        Team.STRDESCRIPTIONNL to detailTeam.strDescriptionNL,
                        Team.STRDESCRIPTIONHU to detailTeam.strDescriptionHU,
                        Team.STRDESCRIPTIONNO to detailTeam.strDescriptionNO,
                        Team.STRDESCRIPTIONIL to detailTeam.strDescriptionIL,
                        Team.STRDESCRIPTIONPL to detailTeam.strDescriptionPL,
                        Team.STRGENDER to detailTeam.strGender,
                        Team.STRCOUNTRY to detailTeam.strCountry,
                        Team.STRTEAMBADGE to detailTeam.strTeamBadge,
                        Team.STRTEAMJERSEY to detailTeam.strTeamJersey,
                        Team.STRTEAMLOGO to detailTeam.strTeamLogo,
                        Team.STRTEAMFANART1 to detailTeam.strTeamFanart1,
                        Team.STRTEAMFANART2 to detailTeam.strTeamFanart2,
                        Team.STRTEAMFANART3 to detailTeam.strTeamFanart3,
                        Team.STRTEAMFANART4 to detailTeam.strTeamFanart4,
                        Team.STRTEAMBANNER to detailTeam.strTeamBanner,
                        Team.STRYOUTUBE to detailTeam.strYoutube,
                        Team.STRLOCKED to detailTeam.strLocked)
            }
            view.showSnackbar("Added to favorite")
        } catch (e: SQLiteConstraintException) {
            view.showSnackbar("Can't add to favorite")
        }
    }

    fun removeFromFavorite() {
        try {
            ctx.database.use {
                delete(Team.TABLE_FAVORITE_TEAM,
                        "(IDTEAM = {idTeam})",
                        "idTeam" to detailTeam.idTeam!!)
            }
            view.showSnackbar("Removed from favorite")
        } catch (e: SQLiteConstraintException) {
            view.showSnackbar("Can't remove from favorite")
        }
    }



    fun favoriteState() {
        ctx.database.use {
            val result = select(Team.TABLE_FAVORITE_TEAM)
                    .whereArgs("(IDTEAM = {idTeam})", "idTeam" to detailTeam.idTeam!!)
            val favorite = result.parseList(classParser<Team>())
            if (!favorite.isEmpty()) ctx.isFavorite = true
        }
    }
}