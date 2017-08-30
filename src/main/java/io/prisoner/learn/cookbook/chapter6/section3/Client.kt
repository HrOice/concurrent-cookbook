package io.prisoner.learn.cookbook.chapter6.section3

import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.TimeUnit
/**
 * DATE: 2017/8/29 22:42 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Client(private val requestList: LinkedBlockingDeque<String>): Runnable {
    override fun run() {
        for (i in 0 until 3) {
            for (j in 0 until 5) {
                val request = StringBuilder()
                request.append(i)
                request.append(":")
                request.append(j)
                try {
                    requestList.put(request.toString())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            TimeUnit.SECONDS.sleep(2)
        }
        println("Client end.")
    }

}

