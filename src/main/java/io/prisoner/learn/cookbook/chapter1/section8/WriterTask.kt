package io.prisoner.learn.cookbook.chapter1.section8

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/19 11:26 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class WriterTask(var deque: Deque<Event>): Runnable {
    override fun run() {
        for (i in 0..100) {
            val event = Event(Date(), "The Thread ${Thread.currentThread().id} has generated an event $i.")
            println("Writer: ${Thread.currentThread().id} gen event $i")
            deque.addFirst(event)
            try {
//                TimeUnit.SECONDS.sleep(1)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        // Daemon thread will be called while cpu is free and the process has not finish
        // the process will finish when there is only daemon thread left
//        TimeUnit.SECONDS.sleep(1)
    }
}