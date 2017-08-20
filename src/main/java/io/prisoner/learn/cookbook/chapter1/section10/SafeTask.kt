package io.prisoner.learn.cookbook.chapter1.section10

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/19 14:20 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class SafeTask: Runnable {
    private val startDate = object: ThreadLocal<Date>() {
        override fun initialValue(): Date{
            return Date()
        }
    }

    override fun run() {
        println("Starting Thread: ${Thread.currentThread().id}, ${startDate.get()}")
        try {
            TimeUnit.SECONDS.sleep(Math.rint(Math.random() * 10).toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        println("Thread finished: ${Thread.currentThread().id}, ${startDate.get()}")
    }
}

fun main(args: Array<String>) {
    val safeTask = SafeTask()
    for (i in 0..9) {
        val thread = Thread(safeTask)
        thread.start()
        try {
            TimeUnit.SECONDS.sleep(2)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}