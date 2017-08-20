package io.prisoner.learn.cookbook.chapter1.section12

import java.util.*

/**
 * DATE: 2017/8/19 16:40 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task: Runnable {
    override fun run() {
        var result: Int
        val random = Random(Thread.currentThread().id)
        while (true) {
            result = 1000/(random.nextDouble() * 1000).toInt()
            println("${Thread.currentThread().id}, $result")
            if (Thread.currentThread().isInterrupted) {
                println("${Thread.currentThread().id} interrupted.")
            }
        }
    }
}