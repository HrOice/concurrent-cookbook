package io.prisoner.learn.cookbook.chapter7.section6

import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/9/3 15:51 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task: Runnable {
    override fun run() {
        println("Task: Begin.")
        TimeUnit.SECONDS.sleep(2)
        println("Task: End.")
    }
}