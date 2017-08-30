package io.prisoner.learn.cookbook.chapter6.section4

import java.util.*
import java.util.concurrent.PriorityBlockingQueue

/**
 * DATE: 2017/8/29 22:57 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val queue = PriorityBlockingQueue<Event>()

    val threads = arrayOfNulls<Thread>(5)

    for (i in 0 until threads.size) {
        threads[i] = Thread(Task(queue, i))
    }

    for (t in threads) {
        t!!.start()
    }

    for (t in threads) {
        t!!.join()
    }

    println("Main: Queue Size: ${queue.size}")

    for (i in 0 until threads.size * 1000) {
        val event = queue.poll()
        println("Thread ${event.thread}, ${event.priority}")
    }

    println("Main: Queue size: ${queue.size}")
    println("Main: End of the program")
}