package io.prisoner.learn.cookbook.chapter3.section8

import java.util.concurrent.Exchanger

/**
 * DATE: 2017/8/22 00:05 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val buffer1 = ArrayList<String>()
    val buffer2 = ArrayList<String>()

    val exchanger = Exchanger<List<String>>()

    val producer = Producer(exchanger, buffer1)
    val consumer = Consumer(exchanger, buffer2)

    val pThread = Thread(producer)
    val cThread = Thread(consumer)
    pThread.start()
    cThread.start()

}