package io.prisoner.learn.cookbook.chapter3.section8

import java.util.concurrent.Exchanger

/**
 * DATE: 2017/8/22 00:05 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Producer(private val exchanger: Exchanger<List<String>>, private var buffer: MutableList<String>): Runnable {
    override fun run() {
        var cycle = 1
        for (i in 0 until 10) {
            println("Producer: Cycle $cycle")
            for (j in 0 until 10) {
                val message = "Event " + i *10 + j
                println("Producer: $message")
                buffer.add(message)
            }
            try {
                val buffer = exchanger.exchange(buffer)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            println("Producer: ${buffer.size}")
            cycle++
        }

    }
}