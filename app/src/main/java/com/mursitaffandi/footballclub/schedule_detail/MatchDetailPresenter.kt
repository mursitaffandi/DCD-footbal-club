package com.mursitaffandi.footballclub.schedule_detail

import android.database.sqlite.SQLiteConstraintException
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.mursitaffandi.footballclub.api.ApiRepository
import com.mursitaffandi.footballclub.api.TheSportDBApi
import com.mursitaffandi.footballclub.entity.match.Match
import com.mursitaffandi.footballclub.entity.team.TeamsLeague
import com.mursitaffandi.footballclub.helper.database
import com.mursitaffandi.footballclub.util.CoroutineContextProvider
import com.mursitaffandi.footballclub.util.simpleDateStringFormat
import kotlinx.android.synthetic.main.activity_match_detail.*
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by mursitaffandi on 7/24/18.
 */
class MatchDetailPresenter(private val ctx: MatchDetailActivity, private val viewMatch: MatchDetailView, private val detailMatch: Match, private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    val request = ApiRepository()
    val gson = Gson()

    fun getDetailTeam(id : String, iv : ImageView) {
        async(context.main){
            val data = bg {
                gson.fromJson(request.doRequest(TheSportDBApi.getLookupTeam(id)),
                        TeamsLeague::class.java)
            }
            Glide.with(ctx).load(data.await().teams[0].strTeamBadge).into(iv)
        }
    }

    fun getDetailTeam(id : String) {
        async(context.main){
            val data = bg {
                gson.fromJson(request.doRequest(TheSportDBApi.getLookupTeam(id)),
                        TeamsLeague::class.java)
            }
            viewMatch.showTeam(data.await().teams[0])
        }
    }

     fun setDetailMatch() {
        ctx.match_date.text = simpleDateStringFormat(detailMatch.dateEvent!!)
        ctx.home_name.text = detailMatch.strHomeTeam
        ctx.away_name.text = detailMatch.strAwayTeam
        ctx.home_score_match.text = detailMatch.intHomeScore
        ctx.away_score_match.text = detailMatch.intAwayScore
        ctx.home_shots.text = detailMatch.intHomeShots
        ctx.away_shot.text = detailMatch.intAwayShots
        ctx.home_goals.text = detailMatch.strHomeGoalDetails
        ctx.away_goals.text = detailMatch.strAwayGoalDetails
        ctx.home_goalkeeper.text = detailMatch.strHomeLineupGoalkeeper
        ctx.away_goalkeeper.text = detailMatch.strAwayLineupGoalkeeper
        ctx.home_defense.text = detailMatch.strHomeLineupDefense
        ctx.away_defense.text = detailMatch.strAwayLineupDefense
        ctx.home_midfield.text = detailMatch.strHomeLineupMidfield
        ctx.away_midfield.text = detailMatch.strAwayLineupMidfield
        ctx.home_forward.text = detailMatch.strHomeLineupForward
        ctx.away_forward.text = detailMatch.strAwayLineupForward
        ctx.home_substitutes.text = detailMatch.strHomeLineupSubstitutes
        ctx.away_substitutes.text = detailMatch.strAwayLineupSubstitutes
     }

     fun addToFavorite() {
        try {
            ctx.database.use {
                insert(Match.TABLE_FAVORITE,
                        Match.ID_MATCH to detailMatch.idEvent,
                        Match.IDSOCCERXML to  detailMatch.idSoccerXML,
                        Match.STREVENT to  detailMatch.strEvent,
                        Match.STRFILENAME to  detailMatch.strFilename,
                        Match.STRSPORT to  detailMatch.strSport,
                        Match.IDLEAGUE to  detailMatch.idLeague,
                        Match.STRLEAGUE to  detailMatch.strLeague,
                        Match.STRSEASON to  detailMatch.strSeason,
                        Match.STRHOMETEAM to  detailMatch.strHomeTeam,
                        Match.STRAWAYTEAM to  detailMatch.strAwayTeam,
                        Match.INTHOMESCORE to  detailMatch.intHomeScore,
                        Match.INTROUND to  detailMatch.intRound,
                        Match.INTAWAYSCORE to  detailMatch.intAwayScore,
                        Match.STRHOMEGOALDETAILS to  detailMatch.strHomeGoalDetails,
                        Match.STRHOMEREDCARDS to  detailMatch.strHomeRedCards,
                        Match.STRHOMEYELLOWCARDS to  detailMatch.strHomeYellowCards,
                        Match.STRHOMELINEUPGOALKEEPER to  detailMatch.strHomeLineupGoalkeeper,
                        Match.STRHOMELINEUPDEFENSE to  detailMatch.strHomeLineupDefense,
                        Match.STRHOMELINEUPMIDFIELD to  detailMatch.strHomeLineupMidfield,
                        Match.STRHOMELINEUPFORWARD to  detailMatch.strHomeLineupForward,
                        Match.STRHOMELINEUPSUBSTITUTES to  detailMatch.strHomeLineupSubstitutes,
                        Match.STRHOMEFORMATION to  detailMatch.strHomeFormation,
                        Match.STRAWAYREDCARDS to  detailMatch.strAwayRedCards,
                        Match.STRAWAYYELLOWCARDS to  detailMatch.strAwayYellowCards,
                        Match.STRAWAYGOALDETAILS to  detailMatch.strAwayGoalDetails,
                        Match.STRAWAYLINEUPGOALKEEPER to  detailMatch.strAwayLineupGoalkeeper,
                        Match.STRAWAYLINEUPDEFENSE to  detailMatch.strAwayLineupDefense,
                        Match.STRAWAYLINEUPMIDFIELD to  detailMatch.strAwayLineupMidfield,
                        Match.STRAWAYLINEUPFORWARD to  detailMatch.strAwayLineupForward,
                        Match.STRAWAYLINEUPSUBSTITUTES to  detailMatch.strAwayLineupSubstitutes,
                        Match.STRAWAYFORMATION to  detailMatch.strAwayFormation,
                        Match.INTHOMESHOTS to  detailMatch.intHomeShots,
                        Match.INTAWAYSHOTS to  detailMatch.intAwayShots,
                        Match.DATEEVENT to  detailMatch.dateEvent,
                        Match.STRDATE to  detailMatch.strDate,
                        Match.STRTIME to  detailMatch.strTime,
                        Match.IDHOMETEAM to  detailMatch.idHomeTeam,
                        Match.IDAWAYTEAM to  detailMatch.idAwayTeam,
                        Match.STRLOCKED to  detailMatch.strLocked)
            }
            viewMatch.showSnackbar("Added to favorite")
        } catch (e: SQLiteConstraintException) {
            viewMatch.showSnackbar("Can't add to favorite")
        }
    }

     fun removeFromFavorite() {
        try {
            ctx.database.use {
                delete(Match.TABLE_FAVORITE,
                        "(ID_MATCH = {idEvent})",
                        "idEvent" to detailMatch.idEvent!!)
            }
            viewMatch.showSnackbar("Removed from favorite")
        } catch (e: SQLiteConstraintException) {
            viewMatch.showSnackbar("Can't remove from favorite")
        }
    }



     fun favoriteState() {
         ctx.database.use {
            val result = select(Match.TABLE_FAVORITE)
                    .whereArgs("(ID_MATCH = {idEvent})", "idEvent" to detailMatch.idEvent!!)
            val favorite = result.parseList(classParser<Match>())
            if (!favorite.isEmpty()) ctx.isFavorite = true
        }
    }
}