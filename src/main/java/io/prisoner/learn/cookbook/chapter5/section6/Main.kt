package io.prisoner.learn.cookbook.chapter5.section6

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/28 21:51 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val generator = ArrayGenerator()
    val array = generator.generateArray(1000)

    val manager = TaskManager()
    val pool = ForkJoinPool()
    val task = SearchNumberTask(array, 0, 1000, 5, manager)
    pool.execute(task)

    pool.shutdown()

    try {
        pool.awaitTermination(1, TimeUnit.DAYS)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }

    println("END.")

}