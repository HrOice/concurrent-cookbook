package io.prisoner.learn.cookbook.chapter2.section8

import java.util.*
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock

/**
 * DATE: 2017/8/20 23:13 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Buffer {
    private val buffer: LinkedList<String>
    private val maxSize: Int
    private val lock: ReentrantLock
    private val lines: Condition
    private val space: Condition
    private var pendingLines: Boolean

    constructor(maxSize: Int) {
        this.maxSize = maxSize
        this.buffer = LinkedList()
        this.lock = ReentrantLock()
        this.lines = lock.newCondition()
        this.space = lock.newCondition()
        this.pendingLines = true
    }

    public fun insert(line: String?) {
        lock.lock()
        try {
            while (buffer.size == maxSize) {
                space.await()
            }
            buffer.offer(line)
            println("${Thread.currentThread().name}: Inserted Line: ${buffer.size}")
            lines.signalAll()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            lock.unlock()
        }
    }

    public fun get(): String? {
        var line: String? = null
        lock.lock()
        try {
            while (buffer.size == 0 && pendingLines) {
                lines.await()
            }
            if (pendingLines) {
                line = buffer.poll()
                println("${Thread.currentThread().name}: Line Readed: ${buffer.size}")
                space.signalAll()
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            lock.unlock()
        }
        return line
    }

    public fun setPendingLines(pendingLines: Boolean) {
        this.pendingLines = pendingLines
    }

    public fun hasPendingLinse(): Boolean {
        return pendingLines
    }
}