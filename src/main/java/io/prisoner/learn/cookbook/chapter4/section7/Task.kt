package io.prisoner.learn.cookbook.chapter4.section7

import java.util.*
import java.util.concurrent.Callable

/**
 * DATE: 2017/8/24 00:03 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task(private val name : String) : Callable<String> {
    override fun call(): String {
        println("$name starting at ${Date()}")
        return "Hello world"
    }
}