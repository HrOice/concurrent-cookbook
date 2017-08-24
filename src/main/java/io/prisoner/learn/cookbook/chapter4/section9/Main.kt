package io.prisoner.learn.cookbook.chapter4.section9

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/24 23:18 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val task = Task("Task")
    val executor = Executors.newCachedThreadPool()
    println("Main: Executing the task.")
    val result = executor.submit(task)
    try {
        TimeUnit.SECONDS.sleep(2)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }

    println("Main: Canceling the Task.")
    //true： cancel the task if running
    //false: wont cancel if the task is running. 1
    result.cancel(false)
    println("Main: Cancelled: ${result.isCancelled}")
    println("Main: Done: ${result.isDone}")
    executor.shutdown()
    println("Main: The executor has finished")

}