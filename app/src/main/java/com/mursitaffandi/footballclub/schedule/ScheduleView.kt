package com.mursitaffandi.footballclub.schedule

import com.mursitaffandi.footballclub.entity.match.Match

/**
 * Created by mursitaffandi on 7/19/18.
 */
interface ScheduleView {
    fun hideLoading()
    fun showSchedule(data: List<Match>)
    fun removeData()
}