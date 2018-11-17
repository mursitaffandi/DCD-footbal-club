package com.mursitaffandi.footballclub.club_detail.overview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mursitaffandi.footballclub.club_detail.players.FragPlayers
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.scrollView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textView

/**
 * Created by mursitaffandi on 7/29/18.
 */
class FragTeamOverview : Fragment() {

    companion object {
        private val ARG_CAUGHT = "arg"
        fun newInstance(caught: String?): FragTeamOverview {
            val args = Bundle()
            args.putString(ARG_CAUGHT, caught)
            val fragment = FragTeamOverview()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            scrollView {
                relativeLayout {
                    textView().text= arguments!!.getString(ARG_CAUGHT)
                }
            }

        }.view
    }
}