package com.mursitaffandi.footballclub.util

import android.view.View
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by mursitaffandi on 7/20/18.
 */
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun simpleDateStringFormat(input:String):String{
    val formatter = SimpleDateFormat("yyy-MM-dd")
    val date = formatter.parse(input)

    val formatOutput = SimpleDateFormat("E, dd MMM yyyy")
    return formatOutput.format(date)
}