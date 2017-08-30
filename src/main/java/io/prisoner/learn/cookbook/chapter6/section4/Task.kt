package io.prisoner.learn.cookbook.chapter6.section4

import java.util.concurrent.PriorityBlockingQueue

/**
 * DATE: 2017/8/29 22:57 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task(private val queue: PriorityBlockingQueue<Event>, private val id: Int): Runnable {
    override fun run() {
        (0 until 1000).mapTo(queue) { Event(id, it) }
    }
}