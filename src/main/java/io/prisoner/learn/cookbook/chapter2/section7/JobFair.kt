package io.prisoner.learn.cookbook.chapter2.section7

/**
 * DATE: 2017/8/20 21:24 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class JobFair(private val printQueue: PrintQueueFair): Runnable {
    override fun run() {
        println("${Thread.currentThread().name} start print a document.")
        printQueue.printJob(Object())
        println("${Thread.currentThread().name} finish print a document.")
    }
}