package com.mursitaffandi.footballclub.helper

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.mursitaffandi.footballclub.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout


/**
 * Created by mursitaffandi on 7/24/18.
 */
class BaseListUI(val anySpinner: Boolean = false) : AnkoComponent<Context> {

    private lateinit var listMatch: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun createView(ui: AnkoContext<Context>) = with(ui) {

            linearLayout {
                lparams (width = matchParent, height = wrapContent)
                orientation = LinearLayout.VERTICAL
                topPadding = dip(42)
                leftPadding = dip(16)
                rightPadding = dip(16)
                backgroundColor = R.color.colorPrimary
                if (anySpinner) spinner{
                    id = R.id.sp_league
                }.lparams(width = matchParent,
                        height = wrapContent)
                swipeRefresh = swipeRefreshLayout {
                    id = R.id.ui_swipeRefresh
                    setColorSchemeResources(R.color.colorAccent,
                            android.R.color.holo_green_light,
                            android.R.color.holo_orange_light,
                            android.R.color.holo_red_light)


                    listMatch = recyclerView {
                        id = R.id.ui_listmatch
                        lparams (width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                    }
                }
            }

    }
}