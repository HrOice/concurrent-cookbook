package io.prisoner.learn.cookbook.chapter7.section2

import java.util.concurrent.Future
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/30 23:40 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val myExecutor = MyExecutor(2, 4, 1000, TimeUnit.MILLISECONDS, LinkedBlockingDeque<Runnable>())
    val results = ArrayList<Future<String>>()

    for (i in 0 until 10) {
        val task = SleepTwoSecondsTask()
        val result = myExecutor.submit(task)
        results.add(result)
    }

    for (i in 0 until 5) {
        println("Main: Result for Task: $i: ${results[i].get()}")
    }

    myExecutor.shutdown()

    for (i in 0 until 5) {
        println("Main: Result for Task: $i: ${results[i].get()}")
    }

    myExecutor.awaitTermination(1, TimeUnit.DAYS)
    println("END")

}