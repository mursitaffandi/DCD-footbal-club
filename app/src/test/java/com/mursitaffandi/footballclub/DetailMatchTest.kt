package com.mursitaffandi.footballclub

import com.google.gson.Gson
import com.mursitaffandi.footballclub.api.ApiRepository
import com.mursitaffandi.footballclub.api.TheSportDBApi
import com.mursitaffandi.footballclub.schedule_detail.MatchDetailActivity
import com.mursitaffandi.footballclub.schedule_detail.MatchDetailPresenter
import com.mursitaffandi.footballclub.schedule_detail.MatchDetailView
import com.mursitaffandi.footballclub.entity.match.Match
import com.mursitaffandi.footballclub.entity.team.Team
import com.mursitaffandi.footballclub.entity.team.TeamsLeague
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


/**
 * Created by mursitaffandi on 7/27/18.
 */
class DetailMatchTest {
    @Mock
    private
    lateinit var viewMatch: MatchDetailView

    @Mock
    private
    lateinit var data: Match

    @Mock
    private
    lateinit var ctx: MatchDetailActivity

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    @Mock
    private
    lateinit var gson: Gson

    private lateinit var presenterMatch: MatchDetailPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenterMatch = MatchDetailPresenter(ctx, viewMatch, data, TestContextProvider())
    }

    @Test
    fun testGetTeamDetail() {
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamsLeague(teams)
        val id = "1234"

        Mockito.`when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLookupTeam(id)),
                TeamsLeague::class.java
        )).thenReturn(response)

        presenterMatch.getDetailTeam(id)
    }
}