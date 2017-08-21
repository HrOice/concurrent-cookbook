package io.prisoner.learn.cookbook.chapter3.section3

import java.util.*
import java.util.concurrent.Semaphore
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * DATE: 2017/8/21 20:47 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class PrintQueue {
    private val semaphore: Semaphore
    private val freePrinters: Array<Boolean?>
    private val lockPrinters: Lock
    constructor() {
        semaphore = Semaphore(3)
        lockPrinters = ReentrantLock()
        freePrinters = arrayOfNulls(3)
        for (i in 0 until 3) {
            freePrinters[i] = true
        }
    }

    public fun printJob(document: Object) {
        try {
            semaphore.acquire()
            val assignedPrinter = getPrinter()
            val duration = (Math.random() * 10).toLong()
            TimeUnit.SECONDS.sleep(duration)
            println("${Thread.currentThread().name}: Printer: ${assignedPrinter} end print job during: $duration time: ${Date().time.toString().substring(7, 13)}")
            freePrinters[assignedPrinter] = true
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            semaphore.release()
        }
    }

    private fun getPrinter(): Int {
        var ret = -1
        try {
            lockPrinters.lock()
            for (i in 0 until 3) {
                if (freePrinters[i]!!) {
                    ret = i
                    freePrinters[i] = false
                    break
                }
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            lockPrinters.unlock()
        }
        return ret
    }
}