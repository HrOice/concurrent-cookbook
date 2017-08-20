package io.prisoner.learn.cookbook.chapter2.section4

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/20 21:01 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Producer(private val eventStorage: EventStorage): Runnable {
    override fun run() {
        for (i in 0..99) {
            TimeUnit.MICROSECONDS.sleep(Random(25).nextLong())
            eventStorage.set()

        }
    }
}