package io.prisoner.learn.cookbook.chapter4.section8

import java.util.*

/**
 * DATE: 2017/8/24 23:05 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task(private val name: String): Runnable {
    override fun run() {
        println("$name starting at : ${Date()}")

    }
}