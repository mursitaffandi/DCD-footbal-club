package com.mursitaffandi.footballclub.helper.schedule

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.mursitaffandi.footballclub.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by mursitaffandi on 7/24/18.
 */
class ItemScheduleUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            cardView {
                id = R.id.cv_match
                lparams(width = matchParent, height = wrapContent) {
                    topMargin = dip(16)
                    rightMargin = dip(16)
                    leftMargin = dip(16)
                }

                linearLayout {
                    orientation = LinearLayout.VERTICAL
                    padding = dip(16)

                    textView {
                        id = R.id.tv_match_date
                        gravity = Gravity.CENTER
                    }.lparams {
                        width = matchParent
                    }

                    linearLayout {
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL

                        textView {
                            id = R.id.tv_home_name
                            gravity = Gravity.CENTER
                        }.lparams {
                            width = matchParent
                            weight = 1f
                        }

                        textView {
                            id = R.id.tv_score_match
                            gravity = Gravity.CENTER
                        }.lparams {
                            width = matchParent
                            weight = 1f
                        }

                        textView {
                            id = R.id.tv_away_name
                            gravity = Gravity.CENTER
                        }.lparams {
                            width = matchParent
                            weight = 1f
                        }
                    }
                }
            }
        }
    }
}