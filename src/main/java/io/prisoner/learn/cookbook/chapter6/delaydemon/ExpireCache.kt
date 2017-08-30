package io.prisoner.learn.cookbook.chapter6.delaydemon

import java.util.*
import java.util.concurrent.DelayQueue

/**
 * DATE: 2017/8/30 00:00 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class ExpireCache {
    private val queue = DelayQueue<Event>()

    init {
        val t = Thread(Runnable {
            start()
        })
        t.start()
    }

    public fun put(event: Event?) {
        if (null == event) return
        queue.add(event)
    }

    public fun size(): Int {
        return queue.size
    }

    private fun start() {
        while(true) {
            val event = queue.take()
            println("get a event: ${event.id}: ${event.exeTime} At ${Date()}")
        }
    }
}