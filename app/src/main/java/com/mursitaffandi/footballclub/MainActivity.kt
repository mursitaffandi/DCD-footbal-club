package com.mursitaffandi.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mursitaffandi.footballclub.R.id.bnav_match
import com.mursitaffandi.footballclub.R.id.bnav_team
import com.mursitaffandi.footballclub.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import com.mursitaffandi.footballclub.finding.SearchActivity
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var mSelectedItemBottomNav: Int = 0
    private val SELECTED_ITEM = "arg_selected_item"
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        if (savedInstanceState != null)
            mSelectedItemBottomNav = savedInstanceState.getInt(SELECTED_ITEM, 0)

        bottom_navigation.selectedItemId = bottom_navigation!!.menu.getItem(mSelectedItemBottomNav).itemId

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId ){
                bnav_match -> mSelectedItemBottomNav = 0
                bnav_team -> mSelectedItemBottomNav = 1
                else -> mSelectedItemBottomNav = 2
            }
             searchView.visibility = if (mSelectedItemBottomNav==2) View.GONE else View.VISIBLE
            loadNavbottomFragment(mSelectedItemBottomNav)
            true
        }
        loadNavbottomFragment(mSelectedItemBottomNav)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SELECTED_ITEM, mSelectedItemBottomNav)
        super.onSaveInstanceState(outState)
    }

    private fun loadNavbottomFragment(idxNav: Int) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, ParentFagNavBottom.newInstance(idxNav), ParentFagNavBottom::class.simpleName)
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)

        searchView = menu.findItem(R.id.action_search).getActionView() as SearchView
        searchView.setQueryHint(resources.getString(R.string.label_menu_search))
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                startActivity<SearchActivity>("KEY_SEARCH" to query, "TYPE_SEARCH" to mSelectedItemBottomNav)
                return false
            }

        })

        return true
    }

}