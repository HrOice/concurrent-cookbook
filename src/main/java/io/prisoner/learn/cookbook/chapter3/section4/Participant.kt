package io.prisoner.learn.cookbook.chapter3.section4

import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/21 21:28 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Participant(private val videoconference: Videoconference, private val name: String): Runnable {
    override fun run() {
        val duration = (Math.random() * 10).toLong()
        try {
            TimeUnit.SECONDS.sleep(duration)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        videoconference.arrive(name)
    }
}