package io.prisoner.learn.cookbook.chapter6.section2

import java.util.concurrent.ConcurrentLinkedDeque

/**
 * DATE: 2017/8/29 22:28 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class AddTask(private val list: ConcurrentLinkedDeque<String>): Runnable {
    override fun run() {
        val name = Thread.currentThread().name
        (0 until 10000).mapTo(list) { name + " Element $it" }
    }
}