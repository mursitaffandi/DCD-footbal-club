package com.mursitaffandi.footballclub.helper.club

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.mursitaffandi.footballclub.entity.team.Team
import org.jetbrains.anko.AnkoContext

/**
 * Created by mursitaffandi on 7/29/18.
 */
class ClubsAdapter (private val matchMatches: List<Team>, private val listener: (Team) -> Unit)
    : RecyclerView.Adapter<ClubViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(ItemClubUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bindItem(matchMatches[position], listener)
    }

    override fun getItemCount(): Int = matchMatches.size

}
