package io.prisoner.learn.cookbook.chapter3.section8

import java.util.concurrent.Exchanger

/**
 * DATE: 2017/8/22 00:05 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Consumer(private val exchanger: Exchanger<List<String>>, private var buffer: MutableList<String>): Runnable {
    override fun run() {
        var cycle = 1
        for (i in 0 until 10) {
            println("Consumer: Cycle $cycle")

            try {
                buffer = exchanger.exchange(buffer) as MutableList<String>
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            println("Consumer: ${buffer.size}")
            for (j in 0 until 10) {
                val message = buffer[0]
                println("Consumer: $message")
                buffer.removeAt(0)
            }
            cycle++
        }
    }
}