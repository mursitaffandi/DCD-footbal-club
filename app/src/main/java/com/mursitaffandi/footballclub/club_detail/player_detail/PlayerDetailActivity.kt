package com.mursitaffandi.footballclub.club_detail.player_detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.mursitaffandi.footballclub.R
import com.mursitaffandi.footballclub.entity.team.Team
import com.mursitaffandi.footballclub.entity.team.player.Player
import kotlinx.android.synthetic.main.activity_player_detail.*
import org.jetbrains.anko.design.snackbar

/**
 * Created by mursitaffandi on 7/29/18.
 */
class PlayerDetailActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)
        val intent = intent
        var dataPlayer = intent.getParcelableExtra<Player>("dataPlayer")
supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        var urlImage: String?
                = if (!dataPlayer.strFanart1.isNullOrBlank()) dataPlayer.strFanart1 else if (!dataPlayer.strThumb.isNullOrBlank())dataPlayer.strThumb else dataPlayer.strCutout
        Glide.with(this).load(dataPlayer.strFanart1).into(iv_player_banner)
        tv_player_height.text = dataPlayer.strHeight
        tv_player_weight.text =  dataPlayer.strWeight
        tv_player_position.text = dataPlayer.strPosition
        tv_player_desc.text = dataPlayer.strDescriptionEN
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            return true

    }
}