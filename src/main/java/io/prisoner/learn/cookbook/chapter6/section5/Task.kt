package io.prisoner.learn.cookbook.chapter6.section5

import java.util.*
import java.util.concurrent.DelayQueue

/**
 * DATE: 2017/8/29 23:17 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task(private val id: Int, private val queue: DelayQueue<Event>): Runnable {
    override fun run() {
        val now = Date()
        val delay = Date()

        delay.time = now.time + id * 1000
        println("Thread: $id: $delay")

        for (i in 0 until 100000) {
            val event = Event(delay)
            queue.add(event)
        }
    }
}