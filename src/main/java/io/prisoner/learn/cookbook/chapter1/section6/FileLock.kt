package io.prisoner.learn.cookbook.chapter1.section6

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/18 23:22 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class FileLock: Runnable {
    override fun run() {
        while (true) {
            System.out.println("${Date()}")
            try {
                TimeUnit.SECONDS.sleep(1)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}

fun main(args: Array<String>) {
    val thread = Thread(FileLock())
    thread.start()
    try {
        TimeUnit.SECONDS.sleep(5)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
    thread.interrupt()
}