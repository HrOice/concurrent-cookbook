package io.prisoner.learn.cookbook.chapter7.section6

import java.util.concurrent.RunnableScheduledFuture
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/9/3 15:46 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyScheduledThreadPoolExecutor(corePoolSize: Int): ScheduledThreadPoolExecutor(corePoolSize) {
    override fun <V : Any?> decorateTask(runnable: Runnable?, task: RunnableScheduledFuture<V>?): RunnableScheduledFuture<V> {
        return MyScheduledTask(task!!, null, runnable!!, this)
    }

    override fun scheduleAtFixedRate(command: Runnable?, initialDelay: Long, period: Long, unit: TimeUnit?): ScheduledFuture<*> {
        val task = super.scheduleAtFixedRate(command, initialDelay, period, unit)
        val myTask = task as MyScheduledTask
        myTask.setPeriod(TimeUnit.MILLISECONDS.convert(period, unit))
        return task
    }
}