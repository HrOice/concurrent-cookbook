package io.prisoner.learn.cookbook.chapter2.section8

/**
 * DATE: 2017/8/20 23:30 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val fileMock = FileMock(100, 10)
    val buffer = Buffer(20)
    val pThread = Thread(Producer(fileMock, buffer))
    val cThreads = arrayOfNulls<Thread>(3)
    for (i in 0 until 3) {
        cThreads[i] = Thread(Consumer(fileMock, buffer), "Consumer $i")
    }
    pThread.start()
    for (i in 0 until 3) {
        cThreads[i]!!.start()
    }
}