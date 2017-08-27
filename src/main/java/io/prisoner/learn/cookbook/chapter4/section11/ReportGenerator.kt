package io.prisoner.learn.cookbook.chapter4.section11

import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/26 19:42 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class ReportGenerator(private val sender: String, private val title: String): Callable<String> {
    override fun call(): String {
        try {
            val duration = (Math.random() * 10).toLong()
            println("${sender}_$title: ReportGenerator: Generating a report during $duration Seconds.")
            TimeUnit.SECONDS.sleep(duration)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return sender + ":" + title
    }
}
