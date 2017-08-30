package io.prisoner.learn.cookbook.chapter6.delaydemon

import java.util.*
import java.util.concurrent.Delayed
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/30 00:00 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Event( val exeTime: Date,
             val id: Int): Delayed {
//    private val restTime: Long
//    init {
//        val now = Date()
//        restTime = exeTime - now.time
//    }
    override fun getDelay(unit: TimeUnit?): Long {
        val now = Date()
        return unit!!.convert(exeTime.time - now.time, TimeUnit.MILLISECONDS)
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