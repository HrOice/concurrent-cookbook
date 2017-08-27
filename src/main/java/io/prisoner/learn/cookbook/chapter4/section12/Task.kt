package io.prisoner.learn.cookbook.chapter4.section12

import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/27 15:26 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task(private val name: String): Runnable {
    override fun run() {
        println("Task $name Starting")
        try {
            val duration = (Math.random() * 10).toLong()
            println("Task $name: ReportGenerator: Generating a report during $duration seconds.")
            TimeUnit.SECONDS.sleep(duration)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        println("Task $name Ending")
    }

    override fun toString(): String {
        return name
    }
}