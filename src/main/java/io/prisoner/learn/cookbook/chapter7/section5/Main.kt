package io.prisoner.learn.cookbook.chapter7.section5

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/31 23:55 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val tf = MyThreadFactory("factory")
    val executor = Executors.newCachedThreadPool(tf)
    val task = MyTask()
    executor.submit(task)
    executor.shutdown()
    executor.awaitTermination(1, TimeUnit.DAYS)
    println("END")
}