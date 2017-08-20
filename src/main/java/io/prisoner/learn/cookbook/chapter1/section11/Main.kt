package io.prisoner.learn.cookbook.chapter1.section11

import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/19 16:03 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val threadGroup = ThreadGroup("Searcher")
    val result = Result()
    val searchTask = SearchTask(result)
    for (i in 1..10) {
        val thread = Thread(threadGroup, searchTask)
        thread.start()
        TimeUnit.SECONDS.sleep(1)
    }
    println("number of threads: ${threadGroup.activeCount()}")
    println("list of threads: ${threadGroup.list()}")
    val threads = arrayOfNulls<Thread>(10)
    threadGroup.enumerate(threads)
    for (i in 0..9) {
        println("Thread ${threads[i]!!.name}, ${threads[i]!!.state}")
    }
    waitFinish(threadGroup)
    threadGroup.interrupt()
}


fun  waitFinish(threadGroup: ThreadGroup) {
    while (threadGroup.activeCount() > 9) {
        TimeUnit.SECONDS.sleep(1)
    }
}