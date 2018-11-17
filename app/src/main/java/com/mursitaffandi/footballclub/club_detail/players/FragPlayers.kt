package com.mursitaffandi.footballclub.club_detail.players

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.mursitaffandi.footballclub.R
import com.mursitaffandi.footballclub.api.ApiRepository
import com.mursitaffandi.footballclub.club_detail.player_detail.PlayerDetailActivity
import com.mursitaffandi.footballclub.entity.team.player.Player
import com.mursitaffandi.footballclub.helper.BaseListUI
import com.mursitaffandi.footballclub.helper.player.PlayerAdapter
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by mursitaffandi on 7/29/18.
 */
class FragPlayers:Fragment(), PlayersView {
    override fun showPlayer(player: List<Player>) {
        swipeRefresh.isRefreshing = false
        players.clear()
        players.addAll(player)
        adapter.notifyDataSetChanged()
    }

    companion object {
        private val ARG_CAUGHT = "arg"
        fun newInstance(caught: String): FragPlayers {
            val args = Bundle()
            args.putString(ARG_CAUGHT, caught)
            val fragment = FragPlayers()
            fragment.arguments = args
            return fragment
        }
    }
    private lateinit var presenter: PlayersPresenter
    private var players: MutableList<Player> = mutableListOf()
    private lateinit var adapter: PlayerAdapter
    private lateinit var listSchedule: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var view: BaseListUI

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view= BaseListUI()
        val v : View = view.createView(AnkoContext.create(ctx))
        listSchedule = v.find(R.id.ui_listmatch)
        swipeRefresh = v.find(R.id.ui_swipeRefresh)

        val request = ApiRepository()
        val gson = Gson()
        presenter = PlayersPresenter(this, request, gson)

        adapter = PlayerAdapter(players) {
            startActivity<PlayerDetailActivity>("dataPlayer" to it)
        }


        listSchedule.adapter = adapter

        swipeRefresh.onRefresh {
            presenter.loadPlayer(arguments!!.getString(ARG_CAUGHT))
        }
        presenter.loadPlayer(arguments!!.getString(ARG_CAUGHT))

        return v
    }
}