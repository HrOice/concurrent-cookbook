package io.prisoner.learn.cookbook.chapter7.section3

import java.util.concurrent.PriorityBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/31 00:06 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val executor = ThreadPoolExecutor(2,
            2,
            1,
            TimeUnit.SECONDS, PriorityBlockingQueue<Runnable>())

    (0 until 4)
            .map { MyPriorityTask(it, "Task $it") }
            .forEach { executor.submit(it) }

    TimeUnit.SECONDS.sleep(1)

    (4 until 8)
            .map { MyPriorityTask(it, "Task $it") }
            .forEach {executor.submit(it)}

    executor.shutdown()
    executor.awaitTermination(1, TimeUnit.DAYS)
    println("END")
}