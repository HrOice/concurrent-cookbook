package io.prisoner.learn.cookbook.chapter1.section7

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/18 23:30 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class NetConnectionsLoader: Runnable {
    override fun run() {
        println("Begin net connection loading: ${Date()}")
        try {
            TimeUnit.SECONDS.sleep(6)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        println("net connection load finished: ${Date()}")
    }
}
