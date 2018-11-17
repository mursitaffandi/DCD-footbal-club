package com.mursitaffandi.footballclub.api

import java.net.URL

/**
 * Created by mursitaffandi on 7/20/18.
 */
class ApiRepository{
    fun doRequest(url: String): String {
        return URL(url).readText()
    }
}
