package com.mursitaffandi.footballclub.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.mursitaffandi.footballclub.entity.match.Match
import com.mursitaffandi.footballclub.entity.team.Team
import org.jetbrains.anko.db.*

/**
 * Created by mursitaffandi on 7/24/18.
 */
class HelperDBDriver (ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FavoriteMatch.db", null, 1) {
    companion object {
        private var instance: HelperDBDriver? = null

        @Synchronized
        fun getInstance(ctx: Context): HelperDBDriver {
            if (instance == null) {
                instance = HelperDBDriver(ctx.applicationContext)
            }
            return instance as HelperDBDriver
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(Match.TABLE_FAVORITE, true,
                Match.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                Match.ID_MATCH to TEXT + UNIQUE,
                Match.IDSOCCERXML to TEXT,
                Match.STREVENT to TEXT,
                Match.STRFILENAME to TEXT,
                Match.STRSPORT to TEXT,
                Match.IDLEAGUE to TEXT,
                Match.STRLEAGUE to TEXT,
                Match.STRSEASON to TEXT,
                Match.STRHOMETEAM to TEXT,
                Match.STRAWAYTEAM to TEXT,
                Match.INTHOMESCORE to TEXT,
                Match.INTROUND to TEXT,
                Match.INTAWAYSCORE to TEXT,
                Match.STRHOMEGOALDETAILS to TEXT,
                Match.STRHOMEREDCARDS to TEXT,
                Match.STRHOMEYELLOWCARDS to TEXT,
                Match.STRHOMELINEUPGOALKEEPER to TEXT,
                Match.STRHOMELINEUPDEFENSE to TEXT,
                Match.STRHOMELINEUPMIDFIELD to TEXT,
                Match.STRHOMELINEUPFORWARD to TEXT,
                Match.STRHOMELINEUPSUBSTITUTES to TEXT,
                Match.STRHOMEFORMATION to TEXT,
                Match.STRAWAYREDCARDS to TEXT,
                Match.STRAWAYYELLOWCARDS to TEXT,
                Match.STRAWAYGOALDETAILS to TEXT,
                Match.STRAWAYLINEUPGOALKEEPER to TEXT,
                Match.STRAWAYLINEUPDEFENSE to TEXT,
                Match.STRAWAYLINEUPMIDFIELD to TEXT,
                Match.STRAWAYLINEUPFORWARD to TEXT,
                Match.STRAWAYLINEUPSUBSTITUTES to TEXT,
                Match.STRAWAYFORMATION to TEXT,
                Match.INTHOMESHOTS to TEXT,
                Match.INTAWAYSHOTS to TEXT,
                Match.DATEEVENT to TEXT,
                Match.STRDATE to TEXT,
                Match.STRTIME to TEXT,
                Match.IDHOMETEAM to TEXT,
                Match.IDAWAYTEAM to TEXT,
                Match.STRLOCKED to TEXT)

        db.createTable(Team.TABLE_FAVORITE_TEAM, true,
                Team.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                Team.IDTEAM to TEXT + UNIQUE,
                Team.IDSOCCERXML to TEXT,
                Team.INTLOVED to TEXT,
                Team.STRTEAM to TEXT,
                Team.STRTEAMSHORT to TEXT,
                Team.STRALTERNATE to TEXT,
                Team.INTFORMEDYEAR to TEXT,
                Team.STRSPORT to TEXT,
                Team.STRLEAGUE to TEXT,
                Team.IDLEAGUE to TEXT,
                Team.STRDIVISION to TEXT,
                Team.STRMANAGER to TEXT,
                Team.STRSTADIUM to TEXT,
                Team.STRKEYWORDS to TEXT,
                Team.STRRSS to TEXT,
                Team.STRSTADIUMTHUMB to TEXT,
                Team.STRSTADIUMDESCRIPTION to TEXT,
                Team.STRSTADIUMLOCATION to TEXT,
                Team.INTSTADIUMCAPACITY to TEXT,
                Team.STRWEBSITE to TEXT,
                Team.STRFACEBOOK to TEXT,
                Team.STRTWITTER to TEXT,
                Team.STRINSTAGRAM to TEXT,
                Team.STRDESCRIPTIONEN to TEXT,
                Team.STRDESCRIPTIONDE to TEXT,
                Team.STRDESCRIPTIONFR to TEXT,
                Team.STRDESCRIPTIONCN to TEXT,
                Team.STRDESCRIPTIONIT to TEXT,
                Team.STRDESCRIPTIONJP to TEXT,
                Team.STRDESCRIPTIONRU to TEXT,
                Team.STRDESCRIPTIONES to TEXT,
                Team.STRDESCRIPTIONPT to TEXT,
                Team.STRDESCRIPTIONSE to TEXT,
                Team.STRDESCRIPTIONNL to TEXT,
                Team.STRDESCRIPTIONHU to TEXT,
                Team.STRDESCRIPTIONNO to TEXT,
                Team.STRDESCRIPTIONIL to TEXT,
                Team.STRDESCRIPTIONPL to TEXT,
                Team.STRGENDER to TEXT,
                Team.STRCOUNTRY to TEXT,
                Team.STRTEAMBADGE to TEXT,
                Team.STRTEAMJERSEY to TEXT,
                Team.STRTEAMLOGO to TEXT,
                Team.STRTEAMFANART1 to TEXT,
                Team.STRTEAMFANART2 to TEXT,
                Team.STRTEAMFANART3 to TEXT,
                Team.STRTEAMFANART4 to TEXT,
                Team.STRTEAMBANNER to TEXT,
                Team.STRYOUTUBE to TEXT,
                Team.STRLOCKED to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(Match.TABLE_FAVORITE, true)
        db.dropTable(Team.TABLE_FAVORITE_TEAM, true)
    }
}

// Access property for Context
val Context.database: HelperDBDriver
    get() = HelperDBDriver.getInstance(applicationContext)