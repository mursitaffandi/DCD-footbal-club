package com.mursitaffandi.footballclub.entity.match

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Match(
        val dbIdMatch: Long?,
        @SerializedName("idEvent") val idEvent: String?,
        @SerializedName("idSoccerXML") val idSoccerXML: String?,
        @SerializedName("strEvent") val strEvent: String?,
        @SerializedName("strFilename") val strFilename: String?,
        @SerializedName("strSport") val strSport: String?,
        @SerializedName("idLeague") val idLeague: String?,
        @SerializedName("strLeague") val strLeague: String?,
        @SerializedName("strSeason") val strSeason: String?,
        @SerializedName("strHomeTeam") val strHomeTeam: String?,
        @SerializedName("strAwayTeam") val strAwayTeam: String?,
        @SerializedName("intHomeScore") val intHomeScore: String?,
        @SerializedName("intRound") val intRound: String?,
        @SerializedName("intAwayScore") val intAwayScore: String?,
        @SerializedName("strHomeGoalDetails") val strHomeGoalDetails: String?,
        @SerializedName("strHomeRedCards") val strHomeRedCards: String?,
        @SerializedName("strHomeYellowCards") val strHomeYellowCards: String?,
        @SerializedName("strHomeLineupGoalkeeper") val strHomeLineupGoalkeeper: String?,
        @SerializedName("strHomeLineupDefense") val strHomeLineupDefense: String?,
        @SerializedName("strHomeLineupMidfield") val strHomeLineupMidfield: String?,
        @SerializedName("strHomeLineupForward") val strHomeLineupForward: String?,
        @SerializedName("strHomeLineupSubstitutes") val strHomeLineupSubstitutes: String?,
        @SerializedName("strHomeFormation") val strHomeFormation: String?,
        @SerializedName("strAwayRedCards") val strAwayRedCards: String?,
        @SerializedName("strAwayYellowCards") val strAwayYellowCards: String?,
        @SerializedName("strAwayGoalDetails") val strAwayGoalDetails: String?,
        @SerializedName("strAwayLineupGoalkeeper") val strAwayLineupGoalkeeper: String?,
        @SerializedName("strAwayLineupDefense") val strAwayLineupDefense: String?,
        @SerializedName("strAwayLineupMidfield") val strAwayLineupMidfield: String?,
        @SerializedName("strAwayLineupForward") val strAwayLineupForward: String?,
        @SerializedName("strAwayLineupSubstitutes") val strAwayLineupSubstitutes: String?,
        @SerializedName("strAwayFormation") val strAwayFormation: String?,
        @SerializedName("intHomeShots") val intHomeShots: String?,
        @SerializedName("intAwayShots") val intAwayShots: String?,
        @SerializedName("dateEvent") val dateEvent: String?,
        @SerializedName("strDate") val strDate: String?,
        @SerializedName("strTime") val strTime: String?,
        @SerializedName("idHomeTeam") val idHomeTeam: String?,
        @SerializedName("idAwayTeam") val idAwayTeam: String?,
        @SerializedName("strLocked") val strLocked: String?
) :Parcelable{

    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val ID_MATCH: String = "ID_MATCH"
        const val IDSOCCERXML: String = "IDSOCCERXML"
        const val STREVENT: String = "STREVENT"
        const val STRFILENAME: String = "STRFILENAME"
        const val STRSPORT: String = "STRSPORT"
        const val IDLEAGUE: String = "IDLEAGUE"
        const val STRLEAGUE: String = "STRLEAGUE"
        const val STRSEASON: String = "STRSEASON"
        const val STRHOMETEAM: String = "STRHOMETEAM"
        const val STRAWAYTEAM: String = "STRAWAYTEAM"
        const val INTHOMESCORE: String = "INTHOMESCORE"
        const val INTROUND: String = "INTROUND"
        const val INTAWAYSCORE: String = "INTAWAYSCORE"
        const val STRHOMEGOALDETAILS: String = "STRHOMEGOALDETAILS"
        const val STRHOMEREDCARDS: String = "STRHOMEREDCARDS"
        const val STRHOMEYELLOWCARDS: String = "STRHOMEYELLOWCARDS"
        const val STRHOMELINEUPGOALKEEPER: String = "STRHOMELINEUPGOALKEEPER"
        const val STRHOMELINEUPDEFENSE: String = "STRHOMELINEUPDEFENSE"
        const val STRHOMELINEUPMIDFIELD: String = "STRHOMELINEUPMIDFIELD"
        const val STRHOMELINEUPFORWARD: String = "STRHOMELINEUPFORWARD"
        const val STRHOMELINEUPSUBSTITUTES: String = "STRHOMELINEUPSUBSTITUTES"
        const val STRHOMEFORMATION: String = "STRHOMEFORMATION"
        const val STRAWAYREDCARDS: String = "STRAWAYREDCARDS"
        const val STRAWAYYELLOWCARDS: String = "STRAWAYYELLOWCARDS"
        const val STRAWAYGOALDETAILS: String = "STRAWAYGOALDETAILS"
        const val STRAWAYLINEUPGOALKEEPER: String = "STRAWAYLINEUPGOALKEEPER"
        const val STRAWAYLINEUPDEFENSE: String = "STRAWAYLINEUPDEFENSE"
        const val STRAWAYLINEUPMIDFIELD: String = "STRAWAYLINEUPMIDFIELD"
        const val STRAWAYLINEUPFORWARD: String = "STRAWAYLINEUPFORWARD"
        const val STRAWAYLINEUPSUBSTITUTES: String = "STRAWAYLINEUPSUBSTITUTES"
        const val STRAWAYFORMATION: String = "STRAWAYFORMATION"
        const val INTHOMESHOTS: String = "INTHOMESHOTS"
        const val INTAWAYSHOTS: String = "INTAWAYSHOTS"
        const val DATEEVENT: String = "DATEEVENT"
        const val STRDATE: String = "STRDATE"
        const val STRTIME: String = "STRTIME"
        const val IDHOMETEAM: String = "IDHOMETEAM"
        const val IDAWAYTEAM: String = "IDAWAYTEAM"
        const val STRLOCKED: String ="STRLOCKED"
    }
}