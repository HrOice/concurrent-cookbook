package io.prisoner.learn.cookbook.chapter6.section9

import java.util.concurrent.atomic.AtomicIntegerArray

/**
 * DATE: 2017/8/30 23:20 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Decrementer(private val vector: AtomicIntegerArray): Runnable {
    override fun run() {
        for (i in 0 until vector.length()) {
            vector.getAndDecrement(i)
        }
    }
}