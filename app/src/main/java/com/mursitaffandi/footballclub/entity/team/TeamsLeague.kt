package com.mursitaffandi.footballclub.entity.team

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamsLeague(
    @SerializedName("teams") val teams: List<Team>
) : Parcelable