package io.prisoner.learn.cookbook.chapter2.section5

/**
 * DATE: 2017/8/20 21:24 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Job(private val printQueue: PrintQueue): Runnable {
    override fun run() {
        println("${Thread.currentThread().name} start print a document.")
        printQueue.printJob(Object())
        println("${Thread.currentThread().name} finish print a document.")
    }
}