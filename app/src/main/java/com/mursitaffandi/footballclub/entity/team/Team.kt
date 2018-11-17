package com.mursitaffandi.footballclub.entity.team

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
        val dbIdTeam: Long?,
        @SerializedName("idTeam") val idTeam: String?,
        @SerializedName("idSoccerXML") val idSoccerXML: String?,
        @SerializedName("intLoved") val intLoved: String?,
        @SerializedName("strTeam") val strTeam: String?,
        @SerializedName("strTeamShort") val strTeamShort: String?,
        @SerializedName("strAlternate") val strAlternate: String?,
        @SerializedName("intFormedYear") val intFormedYear: String?,
        @SerializedName("strSport") val strSport: String?,
        @SerializedName("strLeague") val strLeague: String?,
        @SerializedName("idLeague") val idLeague: String?,
        @SerializedName("strDivision") val strDivision: String?,
        @SerializedName("strManager") val strManager: String?,
        @SerializedName("strStadium") val strStadium: String?,
        @SerializedName("strKeywords") val strKeywords: String?,
        @SerializedName("strRSS") val strRSS: String?,
        @SerializedName("strStadiumThumb") val strStadiumThumb: String?,
        @SerializedName("strStadiumDescription") val strStadiumDescription: String?,
        @SerializedName("strStadiumLocation") val strStadiumLocation: String?,
        @SerializedName("intStadiumCapacity") val intStadiumCapacity: String?,
        @SerializedName("strWebsite") val strWebsite: String?,
        @SerializedName("strFacebook") val strFacebook: String?,
        @SerializedName("strTwitter") val strTwitter: String?,
        @SerializedName("strInstagram") val strInstagram: String?,
        @SerializedName("strDescriptionEN") val strDescriptionEN: String?,
        @SerializedName("strDescriptionDE") val strDescriptionDE: String?,
        @SerializedName("strDescriptionFR") val strDescriptionFR: String?,
        @SerializedName("strDescriptionCN") val strDescriptionCN: String?,
        @SerializedName("strDescriptionIT") val strDescriptionIT: String?,
        @SerializedName("strDescriptionJP") val strDescriptionJP: String?,
        @SerializedName("strDescriptionRU") val strDescriptionRU: String?,
        @SerializedName("strDescriptionES") val strDescriptionES: String?,
        @SerializedName("strDescriptionPT") val strDescriptionPT: String?,
        @SerializedName("strDescriptionSE") val strDescriptionSE: String?,
        @SerializedName("strDescriptionNL") val strDescriptionNL: String?,
        @SerializedName("strDescriptionHU") val strDescriptionHU: String?,
        @SerializedName("strDescriptionNO") val strDescriptionNO: String?,
        @SerializedName("strDescriptionIL") val strDescriptionIL: String?,
        @SerializedName("strDescriptionPL") val strDescriptionPL: String?,
        @SerializedName("strGender") val strGender: String?,
        @SerializedName("strCountry") val strCountry: String?,
        @SerializedName("strTeamBadge") val strTeamBadge: String?,
        @SerializedName("strTeamJersey") val strTeamJersey: String?,
        @SerializedName("strTeamLogo") val strTeamLogo: String?,
        @SerializedName("strTeamFanart1") val strTeamFanart1: String?,
        @SerializedName("strTeamFanart2") val strTeamFanart2: String?,
        @SerializedName("strTeamFanart3") val strTeamFanart3: String?,
        @SerializedName("strTeamFanart4") val strTeamFanart4: String?,
        @SerializedName("strTeamBanner") val strTeamBanner: String?,
        @SerializedName("strYoutube") val strYoutube: String?,
        @SerializedName("strLocked") val strLocked: String?
): Parcelable {

    companion object {
        const val TABLE_FAVORITE_TEAM: String = "TABLE_FAVORITE_TEAM"
        const val ID: String = "ID_"
        const val IDTEAM : String = "IDTEAM"
        const val IDSOCCERXML : String = "IDSOCCERXML"
        const val INTLOVED : String = "INTLOVED"
        const val STRTEAM : String = "STRTEAM"
        const val STRTEAMSHORT : String = "STRTEAMSHORT"
        const val STRALTERNATE : String = "STRALTERNATE"
        const val INTFORMEDYEAR : String = "INTFORMEDYEAR"
        const val STRSPORT : String = "STRSPORT"
        const val STRLEAGUE : String = "STRLEAGUE"
        const val IDLEAGUE : String = "IDLEAGUE"
        const val STRDIVISION : String = "STRDIVISION"
        const val STRMANAGER : String = "STRMANAGER"
        const val STRSTADIUM : String = "STRSTADIUM"
        const val STRKEYWORDS : String = "STRKEYWORDS"
        const val STRRSS : String = "STRRSS"
        const val STRSTADIUMTHUMB : String = "STRSTADIUMTHUMB"
        const val STRSTADIUMDESCRIPTION : String = "STRSTADIUMDESCRIPTION"
        const val STRSTADIUMLOCATION : String = "STRSTADIUMLOCATION"
        const val INTSTADIUMCAPACITY : String = "INTSTADIUMCAPACITY"
        const val STRWEBSITE : String = "STRWEBSITE"
        const val STRFACEBOOK : String = "STRFACEBOOK"
        const val STRTWITTER : String = "STRTWITTER"
        const val STRINSTAGRAM : String = "STRINSTAGRAM"
        const val STRDESCRIPTIONEN : String = "STRDESCRIPTIONEN"
        const val STRDESCRIPTIONDE : String = "STRDESCRIPTIONDE"
        const val STRDESCRIPTIONFR : String = "STRDESCRIPTIONFR"
        const val STRDESCRIPTIONCN : String = "STRDESCRIPTIONCN"
        const val STRDESCRIPTIONIT : String = "STRDESCRIPTIONIT"
        const val STRDESCRIPTIONJP : String = "STRDESCRIPTIONJP"
        const val STRDESCRIPTIONRU : String = "STRDESCRIPTIONRU"
        const val STRDESCRIPTIONES : String = "STRDESCRIPTIONES"
        const val STRDESCRIPTIONPT : String = "STRDESCRIPTIONPT"
        const val STRDESCRIPTIONSE : String = "STRDESCRIPTIONSE"
        const val STRDESCRIPTIONNL : String = "STRDESCRIPTIONNL"
        const val STRDESCRIPTIONHU : String = "STRDESCRIPTIONHU"
        const val STRDESCRIPTIONNO : String = "STRDESCRIPTIONNO"
        const val STRDESCRIPTIONIL : String = "STRDESCRIPTIONIL"
        const val STRDESCRIPTIONPL : String = "STRDESCRIPTIONPL"
        const val STRGENDER : String = "STRGENDER"
        const val STRCOUNTRY : String = "STRCOUNTRY"
        const val STRTEAMBADGE : String = "STRTEAMBADGE"
        const val STRTEAMJERSEY : String = "STRTEAMJERSEY"
        const val STRTEAMLOGO : String = "STRTEAMLOGO"
        const val STRTEAMFANART1 : String = "STRTEAMFANART1"
        const val STRTEAMFANART2 : String = "STRTEAMFANART2"
        const val STRTEAMFANART3 : String = "STRTEAMFANART3"
        const val STRTEAMFANART4 : String = "STRTEAMFANART4"
        const val STRTEAMBANNER : String = "STRTEAMBANNER"
        const val STRYOUTUBE : String = "STRYOUTUBE"
        const val STRLOCKED : String = "STRLOCKED"
    }
}