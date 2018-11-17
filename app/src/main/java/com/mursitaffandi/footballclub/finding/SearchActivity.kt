package com.mursitaffandi.footballclub.finding

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.mursitaffandi.footballclub.R
import com.mursitaffandi.footballclub.club.FragClubs
import com.mursitaffandi.footballclub.schedule.FragSchedules
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.matchParent

/**
 * Created by mursitaffandi on 7/28/18.
 */
class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        frameLayout {
            id=R.id.frame_search
            lparams(width = matchParent,
                    height = matchParent)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        var keySearch = intent.getStringExtra("KEY_SEARCH")
        var typeSearch = intent.getIntExtra("TYPE_SEARCH",0)


        val mFragmentList = mutableListOf<Fragment>()
        mFragmentList.add(FragSchedules.newInstance(3,keySearch))
        mFragmentList.add(FragClubs.newInstance(3,keySearch))

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_search, mFragmentList[typeSearch], mFragmentList[typeSearch]::class.simpleName)
                .commit()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
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


}