package io.prisoner.learn.cookbook.chapter1.section11

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/19 15:39 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class SearchTask(private val result: Result): Runnable {
    override fun run() {
        val name = Thread.currentThread().name
        println("Thread $name start")
        try {
            doTask()
            result.setResult(name)
        } catch (e: InterruptedException) {
            println("Thread $name Interrupted.")
        }
        println("Thread $name End.")
    }

    private fun doTask() {
        val random = Random(Date().time)
        val value: Long = (random.nextDouble() * 100).toLong()
        println("Thread ${Thread.currentThread().name}, $value")
        TimeUnit.SECONDS.sleep(value)
    }
}