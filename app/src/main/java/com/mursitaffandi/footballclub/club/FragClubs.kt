package com.mursitaffandi.footballclub.club

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import com.google.gson.Gson
import com.mursitaffandi.footballclub.R
import com.mursitaffandi.footballclub.api.ApiRepository
import com.mursitaffandi.footballclub.club_detail.TeamDetailActivity
import com.mursitaffandi.footballclub.entity.league.League
import com.mursitaffandi.footballclub.entity.league.List_league
import com.mursitaffandi.footballclub.entity.team.Team
import com.mursitaffandi.footballclub.helper.BaseListUI
import com.mursitaffandi.footballclub.helper.club.ClubsAdapter
import com.mursitaffandi.footballclub.helper.league.AdapterSpinnerLeague
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity
import java.io.BufferedReader
import java.io.InputStreamReader


/**
 * Created by mursitaffandi on 7/29/18.
 */
class FragClubs : Fragment(), ClubsView {
    companion object {
        private val ARG_CAUGHT = "arg"
        private val ARG_KEY = "keyword"
        fun newInstance(caught: Int,keySearch: String=""): FragClubs {
            val args = Bundle()
            args.putInt(ARG_CAUGHT, caught)
            args.putString(ARG_KEY, keySearch)
            val fragment = FragClubs()
            fragment.arguments = args
            return fragment
        }
    }
    override fun showClubs(data: List<Team>) {
        swipeRefresh.isRefreshing = false
        schedules.clear()
        schedules.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private lateinit var presenter: ClubsPresenter
    private var schedules: MutableList<Team> = mutableListOf()
    private lateinit var adapter: ClubsAdapter
    private lateinit var listSchedule: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var view: BaseListUI
    private lateinit var spinnerLeague: Spinner
    private lateinit var legueAdapter: AdapterSpinnerLeague
    private var legueID: String = "a"
    private var key: String = ""
    private var isUseSpinner: Boolean = true

    private fun parse_league() :List<League> {
        val raw = resources.openRawResource(R.raw.league)
        val rd = BufferedReader(InputStreamReader(raw))
        val gson = Gson()
        val obj = gson.fromJson(rd, List_league::class.java)
        return obj.leagues

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (arguments!!.getInt(ARG_CAUGHT,0)>=2) isUseSpinner = false
        key=arguments!!.getString(ARG_KEY)
        view= BaseListUI(isUseSpinner)
        val v : View = view.createView(AnkoContext.create(ctx))
        listSchedule = v.find(R.id.ui_listmatch)
        swipeRefresh = v.find(R.id.ui_swipeRefresh)

        if (isUseSpinner) {
            spinnerLeague = v.find(R.id.sp_league)

            legueAdapter = AdapterSpinnerLeague(ctx, android.R.layout.simple_spinner_item, parse_league())
            spinnerLeague.setAdapter(legueAdapter)
            spinnerLeague.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    legueID = legueAdapter.getItem(position).idLeague
                    presenter.getClubs(legueID,key)
                }
            }
            legueID = legueAdapter.getItem(spinnerLeague.selectedItemPosition).idLeague
        }
        val request = ApiRepository()
        val gson = Gson()
        presenter = ClubsPresenter(this, request, gson, ctx)

        adapter = ClubsAdapter(schedules) {
            startActivity<TeamDetailActivity>( "dataClub" to it)
        }

        listSchedule.adapter = adapter

        swipeRefresh.onRefresh {
            presenter.getClubs(legueID,key)
        }
        presenter.getClubs(legueID,key)
        return v
    }

    override fun onResume() {
        super.onResume()
        if (arguments!!.getInt(ARG_CAUGHT) == 2)
            presenter.getClubs(legueID,key)
    }
}