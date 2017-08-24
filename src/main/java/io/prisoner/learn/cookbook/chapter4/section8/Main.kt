package io.prisoner.learn.cookbook.chapter4.section8

import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/24 23:05 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val executor = Executors.newScheduledThreadPool(1) as ScheduledExecutorService
    println("Main: Starting at ${Date()}")
    val task = Task("Task")
    val result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS) as ScheduledFuture

    for (i in 0 until 10) {
        println("Main: Delay: ${result.getDelay(TimeUnit.MILLISECONDS)}; Sleep the thread during 500 ms")
        try {
            TimeUnit.MILLISECONDS.sleep(500)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
    executor.shutdown()
    TimeUnit.SECONDS.sleep(5)
    println("Main : Finished at ${Date()}")
}