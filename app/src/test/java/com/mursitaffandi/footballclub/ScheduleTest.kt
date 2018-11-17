package com.mursitaffandi.footballclub

import com.google.gson.Gson
import com.mursitaffandi.footballclub.api.ApiRepository
import com.mursitaffandi.footballclub.api.TheSportDBApi
import com.mursitaffandi.footballclub.entity.match.Match
import com.mursitaffandi.footballclub.entity.match.ScheduleLeague
import com.mursitaffandi.footballclub.schedule.SchedulePresenter
import com.mursitaffandi.footballclub.schedule.ScheduleView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by mursitaffandi on 7/27/18.
 */
class ScheduleTest {
    @Mock
    private
    lateinit var view: ScheduleView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    @Mock
    private
    lateinit var ctxMain: MainActivity

    private lateinit var presenter: SchedulePresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = SchedulePresenter(view, apiRepository, gson, ctxMain,TestContextProvider())
    }

    @Test
    fun testGetTeamList() {
        val teams: MutableList<Match> = mutableListOf()
        val response = ScheduleLeague(teams)

        Mockito.`when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getEventspastleague("4328")),
                ScheduleLeague::class.java
        )).thenReturn(response)

        presenter.getSchedule(1)

        Mockito.verify(view).showSchedule(response.matches)
    }
}