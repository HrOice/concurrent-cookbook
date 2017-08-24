package io.prisoner.learn.cookbook.chapter4.section7

import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/24 00:03 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val exector: ScheduledThreadPoolExecutor = Executors.newScheduledThreadPool(1) as ScheduledThreadPoolExecutor
    println("Main: Starting ${Date()}")
    (0 until 5).map {
        val task = Task("Task $it")
        exector.schedule(task, it.toLong() + 1, TimeUnit.SECONDS)
    }
    exector.shutdown()
    try {
        exector.awaitTermination(7, TimeUnit.SECONDS)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
    println("END ${Date()}")
}