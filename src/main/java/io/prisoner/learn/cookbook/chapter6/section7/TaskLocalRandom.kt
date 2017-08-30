package io.prisoner.learn.cookbook.chapter6.section7

import java.util.concurrent.ThreadLocalRandom

/**
 * DATE: 2017/8/30 22:49 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class TaskLocalRandom: Runnable {
    init {
        ThreadLocalRandom.current()
    }
    override fun run() {
        val name = Thread.currentThread().name
        for (i in 0 until 10) {
            println("$name: ${ThreadLocalRandom.current().nextInt(10)}")
        }
    }
}