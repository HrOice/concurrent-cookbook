package io.prisoner.learn.cookbook.chapter4.section12

import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/27 15:26 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val executionHandler = RejectedTaskController()
    val executor = Executors.newCachedThreadPool() as ThreadPoolExecutor
    executor.rejectedExecutionHandler = executionHandler

    println("Main: Starting.")

    (0 until 3)
            .map { Task("Task $it") }
            .forEach { executor.submit(it) }

    println("Main: Shutting down the Executor")
    executor.shutdown()

    println("Main: Sending another task")
    executor.submit(Task("RejectTask"))

    println("Main: End")
    println("Main: End.")
    executor.awaitTermination(1, TimeUnit.DAYS)
    println("Terminating: ${executor.isTerminating}")
    println("Terminated: ${executor.isTerminated}")
}