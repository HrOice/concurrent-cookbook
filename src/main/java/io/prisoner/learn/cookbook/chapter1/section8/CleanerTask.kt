package io.prisoner.learn.cookbook.chapter1.section8

import java.util.*

/**
 * DATE: 2017/8/19 12:23 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class CleanerTask(private val deque: Deque<Event>): Thread() {
    init {
        isDaemon = true
    }

    override fun run() {
        println("Daemon start")
        while (true) {
            val date = Date()
            clean(date)
        }
    }

    fun clean(date: Date) {
        var difference: Long
        var delete: Boolean
        if (deque.size == 0) {
            return
        }
        delete = false
        do {
            val event = deque.last
            difference = date.time - event.date.time
            if (difference > 10000) {
                println("Cleaner: ${event.event}")
                deque.removeLast()
                delete = true
            }
        } while (difference > 10000)

        if (delete) {
            println("Cleaner: Size of the queue: ${deque.size}.")
        }
    }
}