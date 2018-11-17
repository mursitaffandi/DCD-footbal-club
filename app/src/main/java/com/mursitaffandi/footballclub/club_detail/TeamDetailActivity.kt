package com.mursitaffandi.footballclub.club_detail

import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.mursitaffandi.footballclub.R
import com.mursitaffandi.footballclub.R.layout.activity_club_detail
import com.mursitaffandi.footballclub.api.ApiRepository
import com.mursitaffandi.footballclub.club_detail.overview.FragTeamOverview
import com.mursitaffandi.footballclub.club_detail.players.FragPlayers
import kotlinx.android.synthetic.main.activity_club_detail.*
import com.mursitaffandi.footballclub.entity.team.Team
import com.mursitaffandi.footballclub.entity.team.player.Player
import com.mursitaffandi.footballclub.helper.AdapterFragmentPager
import kotlinx.android.synthetic.main.content_detail_club.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.design.snackbar


/**
 * Created by mursitaffandi on 7/29/18.
 */
class TeamDetailActivity :AppCompatActivity(), TeamDetailView, TabLayout.OnTabSelectedListener {
    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        selectActionTab(tab!!.position)
    }

    override fun showSnackbar(msg: String) {
        Snackbar.make(findViewById(R.id.layout_detail_team),
                msg, Snackbar.LENGTH_SHORT).show()
    }

    private fun selectActionTab(position: Int) {
        tabbar_detail_team.getTabAt(position)!!.select()
    }
    private lateinit var  detailClub : Team
    private lateinit var presenterTeam: TeamDetailPresenter
    var menuItem: Menu? = null
    var isFavorite: Boolean = false
    private lateinit var adapterFragment : AdapterFragmentPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_club_detail)
        supportActionBar?.title = "Team Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        detailClub = intent.getParcelableExtra<Team>("dataClub")

        Glide.with(this).load(detailClub.strTeamBadge).into(iv_detail_header_club)
        tv_detail_club_name.text = detailClub.strTeam
        tv_detail_club_est.text = detailClub.intFormedYear
        tv_detail_club_stadium.text = detailClub.strStadium

        presenterTeam = TeamDetailPresenter(this,detailClub,this)
        presenterTeam.favoriteState()

        vp_detail_club.setClipToPadding(false);
        vp_detail_club.setPadding(0, 60, 0, 0);

        adapterFragment = AdapterFragmentPager(supportFragmentManager)
        tabbar_detail_team.setupWithViewPager(vp_detail_club);

        adapterFragment.addFragment(FragTeamOverview.newInstance(detailClub.strDescriptionEN), getString(R.string.label_tab_team_overview))
        adapterFragment.addFragment(FragPlayers.newInstance(detailClub.idTeam!!), getString(R.string.label_tab_team_players))
        adapterFragment.notifyDataSetChanged()
        vp_detail_club.setAdapter(adapterFragment);
        tabbar_detail_team.setTabMode(TabLayout.MODE_FIXED);
        tabbar_detail_team.setTabGravity(TabLayout.GRAVITY_FILL);
        tabbar_detail_team.setupWithViewPager(vp_detail_club);

        tabbar_detail_team.setOnTabSelectedListener(this);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        setFavorite()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.add_to_favorite -> {
                try {
                    if (isFavorite) presenterTeam.removeFromFavorite() else presenterTeam.addToFavorite()

                    isFavorite = !isFavorite
                    setFavorite()
                } catch (e: Exception) {
                    snackbar(findViewById(R.id.layout_detail_team),e.localizedMessage)
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun setFavorite() {
        menuItem?.getItem(0)?.icon =
                if (isFavorite) ContextCompat.getDrawable(ctx, R.mipmap.ic_nav_unfavorite)
                else ContextCompat.getDrawable(ctx, R.mipmap.ic_nav_favorite)

    }
}