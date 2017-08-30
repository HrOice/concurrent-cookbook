package io.prisoner.learn.cookbook.chapter6.section2

import java.util.concurrent.ConcurrentLinkedDeque

/**
 * DATE: 2017/8/29 22:28 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class PollTask(private val list: ConcurrentLinkedDeque<String>): Runnable {
    override fun run() {
        for (i in 0 until 5000) {
            list.pollFirst()
            list.pollLast()
        }
    }
}