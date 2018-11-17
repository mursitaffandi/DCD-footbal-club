package com.mursitaffandi.footballclub.entity.league

import com.google.gson.annotations.SerializedName
data class League(
    @SerializedName("idLeague") val idLeague: String,
    @SerializedName("strLeague") val strLeague: String
)