package io.prisoner.learn.cookbook.chapter1.section10

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/19 13:56 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class UnsafeTask: Runnable {
    private var startDate: Date? = null
    override fun run() {
        startDate = Date()
        println("Starting Thread: ${Thread.currentThread().id}, $startDate")
        try {
            TimeUnit.SECONDS.sleep(Math.rint(Math.random() * 10).toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        println("Thread finished: ${Thread.currentThread().id}, $startDate")
    }
}

fun main(args: Array<String>) {
    val unsafeTask = UnsafeTask()
    for (i in 0..9) {
        val thread = Thread(unsafeTask)
        thread.start()
        try {
            TimeUnit.SECONDS.sleep(2)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}