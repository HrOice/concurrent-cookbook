package io.prisoner.learn.cookbook.chapter7.section7

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/9/3 17:01 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val factory = MyWorkerThreadFactory()
    val pool = ForkJoinPool(4, factory, null, false)
    val array = arrayOfNulls<Int>(100000)

    for (i in 0 until array.size) {
        array[i] = 1
    }

    val task = MyRecursiveTask(array, 0 , array.size)
    pool.execute(task)
    task.join()
    pool.shutdown()
    pool.awaitTermination(1, TimeUnit.DAYS)
    println("Main: Result: ${task.get()}")

}