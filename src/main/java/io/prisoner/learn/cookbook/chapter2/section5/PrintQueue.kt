package io.prisoner.learn.cookbook.chapter2.section5

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * DATE: 2017/8/20 21:20 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class PrintQueue {
    private final val queueLock: Lock = ReentrantLock()

    public fun printJob(document: Object) {
        queueLock.lock()
        try {
            val duration: Long = (Math.random() * 1000).toLong()
            // a
            println("${Thread.currentThread().name} printing a job during: ${duration}")
            Thread.sleep(duration)
            // b
            println("${Thread.currentThread().name} printed ${duration}")
            // the printA and printB must print continuous
            // it will be non-continuous if you not use the lock
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            queueLock.unlock()
        }
    }
}