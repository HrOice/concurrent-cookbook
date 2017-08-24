package io.prisoner.learn.cookbook.chapter4.section3

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/23 22:12 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task(private val name: String): Runnable {
    private val initDate: Date
    init {
        initDate = Date()
    }

    override fun run() {
        println("${Thread.currentThread().name} create on $initDate")
        println("${Thread.currentThread().name} started on ${Date()}")
        try {
            val duration = (Math.random() * 10).toLong()
            println("${Thread.currentThread().name} doing a task during $duration Seconds")
            TimeUnit.SECONDS.sleep(duration)
        } catch (e: InterruptedException ) {
            e.printStackTrace()
        }

        println("${Thread.currentThread().name} finished on ${Date()}")
    }
}