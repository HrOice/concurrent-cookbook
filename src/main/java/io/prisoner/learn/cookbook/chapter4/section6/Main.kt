package io.prisoner.learn.cookbook.chapter4.section6

import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.ThreadPoolExecutor

/**
 * DATE: 2017/8/23 23:39 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val executor = Executors.newCachedThreadPool() as ThreadPoolExecutor
    val list: MutableList<Task> = ArrayList()
    (0 until 3).mapTo(list) { Task("Task $it") }

    var resultList: MutableList<Future<Result>>? = null
    try {
        resultList = executor.invokeAll(list)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }

    executor.shutdown()
    println("results: printing")
    for (i in 0 until resultList!!.size) {
        try {
            val result = resultList[i].get()
            println("${result.name}: ${result.value}")
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        }

    }
}