package com.mursitaffandi.footballclub.entity.team.player

import com.google.gson.annotations.SerializedName

data class TeamPlayer(
    @SerializedName("player") val player: List<Player>
)