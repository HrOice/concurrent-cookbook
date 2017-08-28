package io.prisoner.learn.cookbook.chapter5.section2

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/27 16:57 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val mock = DocumentMock()
    val document = mock.generateDocument(100, 1000, "the")
    val task = DocumentTask(document, 0, 100, "the")
    val pool = ForkJoinPool()
    pool.execute(task)

    do {
        println("******************************************")
        println("Main: p : ${pool.parallelism}")
        println("Main: active threads : ${pool.activeThreadCount}")
        println("Main: task count : ${pool.queuedTaskCount}")
        println("Main: steal : ${pool.stealCount}")
        println("******************************************")
        TimeUnit.SECONDS.sleep(1)
    } while (!task.isDone)

    pool.shutdown()
    pool.awaitTermination(1, TimeUnit.DAYS)
    println("Main : end : ${task.get()}")
}