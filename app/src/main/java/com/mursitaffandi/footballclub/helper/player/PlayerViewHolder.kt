package com.mursitaffandi.footballclub.helper.player

import android.annotation.SuppressLint
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mursitaffandi.footballclub.R
import com.mursitaffandi.footballclub.entity.match.Match
import com.mursitaffandi.footballclub.entity.team.Team
import com.mursitaffandi.footballclub.entity.team.player.Player
import com.mursitaffandi.footballclub.util.simpleDateStringFormat
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by mursitaffandi on 7/29/18.
 */
class PlayerViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private val nameClub: TextView = view.find(R.id.tv_item_club_name)
    private val badgeClub : ImageView = view.find(R.id.iv_item_club_badge)
    private val cv: CardView = view.find(R.id.cv_club_item)

    @SuppressLint("SetTextI18n")
    fun bindItem(data: Player, listener: (Player) -> Unit) {
        nameClub.text = data.strPlayer
        Glide.with(view).load(data.strCutout).into(badgeClub)

        cv.onClick {
            listener(data)
        }
    }
}