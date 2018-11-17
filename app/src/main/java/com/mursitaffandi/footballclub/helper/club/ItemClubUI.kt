package com.mursitaffandi.footballclub.helper.club

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.mursitaffandi.footballclub.R
import com.mursitaffandi.footballclub.R.id.iv_item_club_badge
import com.mursitaffandi.footballclub.R.id.tv_item_club_name
import com.mursitaffandi.footballclub.R.id.cv_club_item
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by mursitaffandi on 7/29/18.
 */
class ItemClubUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            cardView {
                id = cv_club_item
                lparams(width = matchParent, height = wrapContent) {
                    topMargin = dip(16)
                    rightMargin = dip(16)
                    leftMargin = dip(16)
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = iv_item_club_badge
                    }.lparams{
                        height = dip(50)
                        width = dip(50)
                    }

                    textView {
                        id = tv_item_club_name
                        textSize = 16f
                    }.lparams{
                        margin = dip(15)
                    }

                }
            }
        }
    }
}