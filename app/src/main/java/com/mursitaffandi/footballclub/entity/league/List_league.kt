package com.mursitaffandi.footballclub.entity.league

import com.google.gson.annotations.SerializedName

data class List_league(
    @SerializedName("leagues") val leagues: List<League>
)