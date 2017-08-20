package io.prisoner.learn.cookbook.chapter1.section7

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/18 23:28 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class DataSourceLoader: Runnable {
    override fun run() {
        println("Begin data source loading: ${Date()}")
        try {
            TimeUnit.SECONDS.sleep(4)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        println("data source load finished: ${Date()}")
    }
}

