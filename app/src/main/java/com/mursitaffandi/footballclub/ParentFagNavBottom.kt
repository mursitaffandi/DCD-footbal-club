package com.mursitaffandi.footballclub

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mursitaffandi.footballclub.club.FragClubs
import com.mursitaffandi.footballclub.favorite.TabhostFavorite
import com.mursitaffandi.footballclub.schedule.TabhostSchedule


/**
 * Created by mursitaffandi on 7/24/18.
 */
class ParentFagNavBottom : Fragment() {
    companion object {
        private val ARG_CAUGHT = "arg"
        fun newInstance(caught: Int): ParentFagNavBottom {
            val args = Bundle()
            args.putInt(ARG_CAUGHT, caught)
            val fragment = ParentFagNavBottom()
            fragment.arguments = args
            return fragment
        }
    }

    private val mFragmentList = mutableListOf<Fragment>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.fragment_navbottom, container, false)
        mFragmentList.add(TabhostSchedule())
        mFragmentList.add(FragClubs.newInstance(1))
        mFragmentList.add(TabhostFavorite())
        childFragmentManager
                .beginTransaction()
                .replace(R.id.frame_parent_bottomnav, mFragmentList[arguments!!.getInt(ARG_CAUGHT,0)], mFragmentList[arguments!!.getInt(ARG_CAUGHT,0)]::class.simpleName)
                .commit()
        return v
    }


}