package io.prisoner.learn.cookbook.chapter2.section4

import java.util.*

/**
 * DATE: 2017/8/20 20:50 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class EventStorage(private val maxSize: Int = 10,
                   private val storage: LinkedList<Date> = LinkedList()) {
    private val lock = Object()
    public fun set() = synchronized(lock) {
        while (storage.size == maxSize) {
            try {
                println("storage full")
                //wait() should be contained by an while to check the condition
                lock.wait()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        storage.add(Date())
        println("Set: ${storage.size}")
        lock.notifyAll()
    }

    public fun get() = synchronized(lock) {
        while (storage.size == 0) {
            try {
                println("storage empty")
                lock.wait()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        storage.poll()
        println("Get: ${storage.size}")
        lock.notifyAll()
    }
}