package io.prisoner.learn.cookbook.chapter6.section9

import java.util.concurrent.atomic.AtomicIntegerArray

/**
 * DATE: 2017/8/30 23:21 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val THREADS = 1000
    val vector = AtomicIntegerArray(1000)

    val iThreads = arrayOfNulls<Thread>(THREADS)
    val dThreads = arrayOfNulls<Thread>(THREADS)

    for (i in 0 until THREADS) {
        iThreads[i] = Thread(Incrementer(vector))
        dThreads[i] = Thread(Decrementer(vector))
        iThreads[i]!!.start()
        dThreads[i]!!.start()
    }
    for (i in 0 until THREADS) {
        iThreads[i]!!.join()
        dThreads[i]!!.join()
    }

    for (i in 0 until vector.length()) {
        if (vector.get(i) != 0) {
            println(vector.get(i))
        }
    }
    println("END")
}