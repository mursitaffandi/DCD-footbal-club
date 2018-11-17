package com.mursitaffandi.footballclub.helper.league

import android.content.Context
import android.widget.ArrayAdapter
import com.mursitaffandi.footballclub.entity.league.League
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


/**
 * Created by mursitaffandi on 7/29/18.
 */
class AdapterSpinnerLeague(context: Context, private val layoutResource: Int, private val leagues: List<League>):
        ArrayAdapter<League>(context, layoutResource, leagues) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return createViewFromResource(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return createViewFromResource(position, convertView, parent)
    }


    private fun createViewFromResource(position: Int, convertView: View?, parent: ViewGroup?): View{
        val view: TextView = convertView as TextView? ?: LayoutInflater.from(context).inflate(layoutResource, parent, false) as TextView
        view.text = leagues[position].strLeague
        return view
    }
}