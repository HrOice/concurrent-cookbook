package io.prisoner.learn.cookbook.chapter4.section10

import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/24 23:47 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val executor = Executors.newCachedThreadPool()
    val resultTasks: Array<ResultTask?> = arrayOfNulls(5)
    for (i in 0 until 5) {
        val executorTask = ExecutableTask("Task $i")
        resultTasks[i] = ResultTask(executorTask)
        executor.submit(resultTasks[i])
    }

    try {
        TimeUnit.SECONDS.sleep(5)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }

    for (i in 0 until 5) {
        resultTasks[i]!!.cancel(true)
    }

    for (i in 0 until 5) {
        try {
            if (!resultTasks[i]!!.isCancelled) {
                println(resultTasks[i]!!.get())
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        }
    }

    executor.shutdown()
}