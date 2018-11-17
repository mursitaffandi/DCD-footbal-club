package com.mursitaffandi.footballclub.helper.schedule

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.jetbrains.anko.*
import com.mursitaffandi.footballclub.entity.match.Match

/**
 * Created by mursitaffandi on 7/21/18.
 */
class ScheduleAdapter(private val matchMatches: List<Match>, private val listener: (Match) -> Unit)
    : RecyclerView.Adapter<ScheduleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder(ItemScheduleUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        
        holder.bindItem(matchMatches[position], listener)
    }

    override fun getItemCount(): Int = matchMatches.size

}
