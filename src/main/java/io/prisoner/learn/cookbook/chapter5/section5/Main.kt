package io.prisoner.learn.cookbook.chapter5.section5

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/28 21:33 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val array = arrayOfNulls<Int>(10)
    val task = Task(array, 0, 100)

    val pool = ForkJoinPool()
    pool.execute(task)

    pool.shutdown()
    try {
        pool.awaitTermination(1, TimeUnit.DAYS)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }

    if (task.isCompletedAbnormally) {
        println("Main: An exception has ocurred.")
        println("Main ${task.exception}")
    }
    println("Main: Result: ${task.join()}")

}