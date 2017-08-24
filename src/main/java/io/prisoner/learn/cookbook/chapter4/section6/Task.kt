package io.prisoner.learn.cookbook.chapter4.section6

import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/23 23:39 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task(private val name: String): Callable<Result> {
    override fun call(): Result {
        println("$name starting")
        try {
            val duration = (Math.random() * 10).toLong()
            println("$name waiting $duration seconds for results.")
            TimeUnit.SECONDS.sleep(duration)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        var value = 0
        for (i in 0 until 5) {
            value += (Math.random() * 100).toInt()
        }
        val result = Result()
        result.name = name
        result.value = value
        return result
    }
}