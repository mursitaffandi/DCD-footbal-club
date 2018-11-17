package com.mursitaffandi.footballclub.favorite

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mursitaffandi.footballclub.R
import com.mursitaffandi.footballclub.club.FragClubs
import com.mursitaffandi.footballclub.helper.AdapterFragmentPager
import com.mursitaffandi.footballclub.schedule.FragSchedules
import com.mursitaffandi.footballclub.schedule.TabhostSchedule

/**
 * Created by mursitaffandi on 7/29/18.
 */

class TabhostFavorite: Fragment(), TabLayout.OnTabSelectedListener {

    private lateinit var tabhost: TabLayout
    private lateinit var vpMain : ViewPager
    private lateinit var adapterFragment : AdapterFragmentPager

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        selectActionTab(tab!!.getPosition());
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.tabhost, container, false)
        tabhost = v.findViewById(R.id.tabbar_main)

        vpMain = v.findViewById(R.id.vp_main)
        vpMain.setClipToPadding(false);
        vpMain.setPadding(0, 60, 0, 0);

        adapterFragment = AdapterFragmentPager(childFragmentManager)
        tabhost.setupWithViewPager(vpMain);

        adapterFragment.addFragment(FragSchedules.newInstance(2), getString(R.string.label_tab_match))
        adapterFragment.addFragment(FragClubs.newInstance(2), getString(R.string.label_tab_team))
        adapterFragment.notifyDataSetChanged()
        vpMain.setAdapter(adapterFragment);
        tabhost.setTabMode(TabLayout.MODE_FIXED);
        tabhost.setTabGravity(TabLayout.GRAVITY_FILL);
        tabhost.setupWithViewPager(vpMain);

        tabhost.setOnTabSelectedListener(this);

        return v
    }

    private fun selectActionTab(position: Int) {
        tabhost.getTabAt(position)!!.select()
    }

}
