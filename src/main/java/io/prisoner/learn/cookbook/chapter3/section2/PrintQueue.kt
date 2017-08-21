package io.prisoner.learn.cookbook.chapter3.section2

import java.util.concurrent.Semaphore

/**
 * DATE: 2017/8/21 20:37 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class PrintQueue {
    private val semaphore: Semaphore
    constructor() {
        semaphore = Semaphore(1, true)
    }

    public fun printJob(document: Object) {
        try {
            semaphore.acquire()
            println("${Thread.currentThread().name} start print job")
            val duration = (Math.random() * 1000).toLong()
            Thread.sleep(duration)
            println("${Thread.currentThread().name} end print job")
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            semaphore.release()
        }
    }
}