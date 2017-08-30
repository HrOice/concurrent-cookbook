package io.prisoner.learn.cookbook.chapter6.section5

import java.util.*
import java.util.concurrent.DelayQueue
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/29 23:17 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val queue = DelayQueue<Event>()
    val threads = arrayOfNulls<Thread>(5)

    TimeUnit.SECONDS.sleep(10)

    for (i in 0 until threads.size) {
        val task = Task(i, queue)
        threads[i] = Thread(task)
    }

    for (t in threads) {
        t!!.start()
    }

    for (t in threads) {
        t!!.join()
    }

    do {
        var count = 0
        var event: Event?
        do {
            event = queue.poll()
            if (event != null) count ++
        } while(event != null)
        println(message = "At ${Date()} you have read $count events")
        TimeUnit.MILLISECONDS.sleep(30)
    } while(queue.size > 0)
}