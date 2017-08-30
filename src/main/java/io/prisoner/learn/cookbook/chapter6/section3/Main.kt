package io.prisoner.learn.cookbook.chapter6.section3

import java.util.*
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/29 22:42 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val list = LinkedBlockingDeque<String>()
    val client = Client(list)
    val thread = Thread(client)

    thread.start()
    thread.join()

    for (i in 0 until 5) {
        for (j in 0 until 3) {
            val request = list.poll()
            println("Main: Request $request at ${Date()} size: ${list.size}")
        }
        TimeUnit.MILLISECONDS.sleep(300)
    }

    println("Main: End of the program.")
}