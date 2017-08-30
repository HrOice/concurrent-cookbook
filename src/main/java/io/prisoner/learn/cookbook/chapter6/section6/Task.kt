package io.prisoner.learn.cookbook.chapter6.section6

import java.util.concurrent.ConcurrentSkipListMap

/**
 * DATE: 2017/8/30 22:26 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task(private val map: ConcurrentSkipListMap<String, Contact>, private val id: String): Runnable {
    override fun run() {
        for (i in 0 until 1000) {
            val contact = Contact(id, (i + 1000).toString())
            map.put(id + contact.phone, contact)
        }
    }
}