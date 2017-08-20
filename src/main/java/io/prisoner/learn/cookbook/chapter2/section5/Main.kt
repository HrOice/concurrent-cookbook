package io.prisoner.learn.cookbook.chapter2.section5

/**
 * DATE: 2017/8/20 21:25 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val printQueue = PrintQueueFair()
    val thread = arrayOfNulls<Thread>(10)
    for (i in 0..9) {
        thread[i] = Thread(Job(printQueue))
    }
    for (i in 0..9) {
        thread[i]!!.start()
    }
}