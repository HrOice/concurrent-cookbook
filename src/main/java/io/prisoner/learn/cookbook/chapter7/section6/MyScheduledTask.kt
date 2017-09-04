package io.prisoner.learn.cookbook.chapter7.section6

import java.util.*
import java.util.concurrent.*

/**
 * DATE: 2017/9/3 15:30 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyScheduledTask<V>(private val task: RunnableScheduledFuture<V>,
                         private val result: V?,
                         private val runnable: Runnable,
                         private val executor: ScheduledThreadPoolExecutor):
        FutureTask<V>(runnable, result), RunnableScheduledFuture<V> {

    private var period: Long = 0
    private var startDate: Long = 0

    override fun getDelay(unit: TimeUnit?): Long {
        return if (!isPeriodic) {
            task.getDelay(unit)
        } else {
            if (startDate == 0L) {
                task.getDelay(unit)
            } else {
                val now = Date()
                val delay = startDate - now.time
                unit!!.convert(delay, TimeUnit.MILLISECONDS)
            }
        }
    }

    override fun isPeriodic(): Boolean {
        return task.isPeriodic
    }

    override fun compareTo(other: Delayed?): Int {
        return task.compareTo(other)
    }

    override fun run() {
        if (isPeriodic && !executor.isShutdown) {
            val now = Date()
            startDate = now.time + period
            executor.queue.add(this)
        }
        println("Pre-MyScheduledTask: ${Date()}")
        println("MyScheduledTask: Is Periodic: $isPeriodic")
        super.runAndReset()
        println("Post-MyScheduledTask: ${Date()}")
    }

    public fun setPeriod(period: Long) {
        this.period = period
    }
}