package io.prisoner.learn.cookbook.chapter6.section5

import java.util.*
import java.util.concurrent.Delayed
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/29 23:17 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Event(private val startDate: Date): Delayed {
    override fun getDelay(unit: TimeUnit?): Long {
        val now = Date()
        val diff = startDate.time - now.time
        return unit!!.convert(diff, TimeUnit.MILLISECONDS)
    }

    override fun compareTo(other: Delayed?): Int {
        val result = this.getDelay(TimeUnit.NANOSECONDS) - other!!.getDelay(TimeUnit.NANOSECONDS)
        return when {
            result > 0 -> 1
            result < 0 -> -1
            else -> 0
        }
    }
}