package io.prisoner.learn.cookbook.chapter3.section2

/**
 * DATE: 2017/8/21 20:40 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Job(private val printQueue: PrintQueue): Runnable {

    override fun run() {
        println("${Thread.currentThread().name} prepare print")
        printQueue.printJob(Object())
        println("${Thread.currentThread().name} finish print")
    }
}