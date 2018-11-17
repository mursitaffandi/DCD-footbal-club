package com.mursitaffandi.footballclub.helper.schedule

import android.annotation.SuppressLint
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.mursitaffandi.footballclub.R
import com.mursitaffandi.footballclub.entity.match.Match
import com.mursitaffandi.footballclub.util.simpleDateStringFormat
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by mursitaffandi on 7/24/18.
 */
class ScheduleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val homeName: TextView = view.find(R.id.tv_home_name)
    private val awayName: TextView = view.find(R.id.tv_away_name)
    private val score: TextView = view.find(R.id.tv_score_match)
    private val matchDate: TextView = view.find(R.id.tv_match_date)
    private val cv: CardView = view.find(R.id.cv_match)

    @SuppressLint("SetTextI18n")
    fun bindItem(events: Match, listener: (Match) -> Unit) {
        homeName.text = events.strHomeTeam
        awayName.text = events.strAwayTeam
        if (events.intHomeScore != null) {
            score.text = events.intHomeScore.toString() + " VS " + events.intAwayScore
        } else {
            score.text = " VS "
        }
        matchDate.text = simpleDateStringFormat(events.dateEvent!!)
        cv.onClick {
            listener(events)
        }
    }
}