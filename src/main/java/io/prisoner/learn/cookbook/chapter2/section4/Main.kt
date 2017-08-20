package io.prisoner.learn.cookbook.chapter2.section4

/**
 * DATE: 2017/8/20 21:03 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val eventStorage = EventStorage()
    val producerThread = Thread(Producer(eventStorage))
    val consumerThread = Thread(Consumer(eventStorage))
    producerThread.start()
    consumerThread.start()
}