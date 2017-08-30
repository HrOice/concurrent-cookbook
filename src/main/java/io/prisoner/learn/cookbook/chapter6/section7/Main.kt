package io.prisoner.learn.cookbook.chapter6.section7

/**
 * DATE: 2017/8/30 22:49 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val threads = arrayOfNulls<Thread>(5)
    for (i in 0 until 3) {
        val task = TaskLocalRandom()
        threads[i] = Thread(task)
        threads[i]!!.start()
    }
}