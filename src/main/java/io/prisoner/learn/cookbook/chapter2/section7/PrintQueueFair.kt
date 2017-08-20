package io.prisoner.learn.cookbook.chapter2.section7

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * DATE: 2017/8/20 21:20 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class PrintQueueFair {
    private final val queueLock: Lock = ReentrantLock(true)
    // the Critical Section will select randomly thread when fair is false
    // but it will select a longest wait time thread if fair is true

    public fun printJob(document: Object) {
        queueLock.lock()
        try {
            val duration: Long = (Math.random() * 1000).toLong()
            // a
            println("${Thread.currentThread().name} printing a job during: ${duration}")
            Thread.sleep(duration)
            // the printA and printB must print continuous
            // it will be non-continuous if you not use the lock
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            queueLock.unlock()
        }
        queueLock.lock()
        try {
            val duration: Long = (Math.random() * 1000).toLong()
            println("${Thread.currentThread().name} printing a job during: ${duration}")
            Thread.sleep(duration)

        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            queueLock.unlock()
        }
    }
}