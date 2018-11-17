package com.mursitaffandi.footballclub

import com.mursitaffandi.footballclub.api.ApiRepository
import com.mursitaffandi.footballclub.api.TheSportDBApi
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by mursitaffandi on 7/27/18.
 */
class ApiTeamTest {
    @Test
    fun testDoRequest() {
        val apiRepository = Mockito.mock(ApiRepository::class.java)
        val url = TheSportDBApi.getLookupTeam("133632")
        apiRepository.doRequest(url)
        Mockito.verify(apiRepository).doRequest(url)
    }
}