package com.mursitaffandi.footballclub

import com.mursitaffandi.footballclub.util.simpleDateStringFormat
import org.junit.Test
import org.junit.Assert.*

/**
 * Created by mursitaffandi on 7/27/18.
 */
class UtilDateTest {
    @Test
    fun testToDateSimpleString() {
        val dateFormat = simpleDateStringFormat("2018-05-13")
        assertEquals("Sun, 13 May 2018", dateFormat)
    }
}