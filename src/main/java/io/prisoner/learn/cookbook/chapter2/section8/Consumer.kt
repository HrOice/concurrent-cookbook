package io.prisoner.learn.cookbook.chapter2.section8

import java.util.*

/**
 * DATE: 2017/8/20 23:26 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Consumer(private val mock: FileMock, private val buffer: Buffer): Runnable {
    override fun run() {
        while (buffer.hasPendingLinse()) {
            val line = buffer.get()
            try {
                val random = Random()
                Thread.sleep(random.nextInt(100).toLong())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}