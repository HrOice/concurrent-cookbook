package io.prisoner.learn.cookbook.chapter3.section3

/**
 * DATE: 2017/8/21 21:01 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val printQueue = PrintQueue()
    val threads = arrayOfNulls<Thread>(10)
    for (i in 0 until 10) {
        threads[i] = Thread(Job(printQueue))
    }
    for (i in 0 until 10) {
        threads[i]!!.start()
        Thread.sleep(100)
    }
}