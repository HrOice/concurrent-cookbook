package io.prisoner.learn.cookbook.chapter3.section4

import java.util.concurrent.CountDownLatch

/**
 * DATE: 2017/8/21 21:27 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Videoconference: Runnable {
    private final val controller: CountDownLatch
    constructor(num: Int) {
        controller = CountDownLatch(10)
    }

    fun arrive(name: String) {
        println("${name} has arrived")
        controller.countDown()
        println("Videoconference: Waiting for ${controller.count} participants")
    }

    override fun run() {
        println("Videoconference: Initialization: ${controller.count} participants")
        try {
            controller.await()
            println("Videoconference: All participants has arrived")
            println("Let's start")
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}