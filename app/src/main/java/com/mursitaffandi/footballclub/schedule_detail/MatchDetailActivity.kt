package com.mursitaffandi.footballclub.schedule_detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.mursitaffandi.footballclub.R
import com.mursitaffandi.footballclub.R.id.add_to_favorite
import com.mursitaffandi.footballclub.R.layout.activity_match_detail
import com.mursitaffandi.footballclub.R.menu.detail_menu
import com.mursitaffandi.footballclub.entity.match.Match
import com.mursitaffandi.footballclub.entity.team.Team
import kotlinx.android.synthetic.main.activity_match_detail.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.design.snackbar


class MatchDetailActivity : AppCompatActivity(), MatchDetailView {
    override fun showTeam(team: Team) {
        Log.d(this.packageName, team.strTeam)
    }

    override fun showSnackbar(msg: String) {
        Snackbar.make(findViewById(R.id.ll_detail),
                msg, Snackbar.LENGTH_SHORT).show()
    }

    private lateinit var  detailMatch : Match
    private lateinit var presenterMatch: MatchDetailPresenter
    var menuItem: Menu? = null
    var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_match_detail)
        supportActionBar?.title = "Match Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        detailMatch = intent.getParcelableExtra<Match>("idMatch")
        presenterMatch = MatchDetailPresenter(this,this, detailMatch)

        presenterMatch.favoriteState()
        presenterMatch.getDetailTeam(intent.getStringExtra("idHome"), img_home)
        presenterMatch.getDetailTeam(intent.getStringExtra("idAway"), img_away)
        presenterMatch.setDetailMatch()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(detail_menu, menu)
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
            add_to_favorite -> {
                try {
                    if (isFavorite) presenterMatch.removeFromFavorite() else presenterMatch.addToFavorite()

                    isFavorite = !isFavorite
                    setFavorite()
                } catch (e: Exception) {
                    snackbar(findViewById(R.id.ll_detail),e.localizedMessage)
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
