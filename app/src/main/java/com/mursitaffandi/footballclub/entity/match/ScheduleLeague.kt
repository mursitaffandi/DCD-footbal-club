package com.mursitaffandi.footballclub.entity.match

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ScheduleLeague(
    @SerializedName(value = "events",alternate=arrayOf("event")) var matches: List<Match>
) : Parcelable