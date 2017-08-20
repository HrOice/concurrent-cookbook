package io.prisoner.learn.cookbook.chapter1.section8

import java.util.*

/**
 * DATE: 2017/8/19 12:33 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val duque = ArrayDeque<Event>()
    val writerTask = WriterTask(duque)
    for (i in 0..2) {
        val thread = Thread(writerTask)
        thread.start()
    }
    val cleanTask = CleanerTask(duque)
    cleanTask.start()
}