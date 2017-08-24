package io.prisoner.learn.cookbook.chapter4.section9

import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/24 23:18 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task(private val name: String): Callable<String> {
    override fun call(): String {
        while (true) {
            println("Task: Test")
            TimeUnit.MILLISECONDS.sleep(100)
        }
    }
}