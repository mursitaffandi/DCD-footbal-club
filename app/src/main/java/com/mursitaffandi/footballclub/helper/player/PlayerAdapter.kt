package com.mursitaffandi.footballclub.helper.player

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.mursitaffandi.footballclub.entity.team.Team
import com.mursitaffandi.footballclub.entity.team.player.Player
import com.mursitaffandi.footballclub.helper.club.ClubViewHolder
import com.mursitaffandi.footballclub.helper.club.ItemClubUI
import org.jetbrains.anko.AnkoContext

/**
 * Created by mursitaffandi on 7/29/18.
 */
class PlayerAdapter (private val matchMatches: List<Player>, private val listener: (Player) -> Unit)
    : RecyclerView.Adapter<PlayerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(ItemClubUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bindItem(matchMatches[position], listener)
    }

    override fun getItemCount(): Int = matchMatches.size

}
