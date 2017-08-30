package io.prisoner.learn.cookbook.chapter6.delaydemon

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/30 00:00 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val cache = ExpireCache()
    val random = Random()
    for (i in 0 until 10) {
        val delay = (random.nextInt(10))
        val exeTime = Date(Date().time + delay * 10000)
        println("Main: put a Event($exeTime, $i)")
        cache.put(Event(exeTime, i))
    }
    println("FINISHED")
}