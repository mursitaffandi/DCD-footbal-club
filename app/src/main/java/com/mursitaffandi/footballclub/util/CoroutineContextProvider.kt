package com.mursitaffandi.footballclub.util

import android.content.Context
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext
import org.jetbrains.anko.support.v4.ctx

/**
 * Created by mursitaffandi on 7/27/18.
 */
open class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { UI }
}