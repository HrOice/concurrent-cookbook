package io.prisoner.learn.cookbook.chapter7.section6

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/9/3 15:53 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val executor = MyScheduledThreadPoolExecutor(2)
    var task = Task()

    println("Main: ${Date()}")
    executor.schedule(task, 1, TimeUnit.SECONDS)
    TimeUnit.SECONDS.sleep(3)

    task = Task()
    println("Main: ${Date()}")
    executor.scheduleAtFixedRate(task, 1,3, TimeUnit.SECONDS)
    TimeUnit.SECONDS.sleep(10)
    executor.shutdown()
    executor.awaitTermination(1, TimeUnit.DAYS)
    println("END")

}