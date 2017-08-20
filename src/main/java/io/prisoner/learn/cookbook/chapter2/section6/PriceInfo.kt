package io.prisoner.learn.cookbook.chapter2.section6

import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock

/**
 * DATE: 2017/8/20 21:44 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class PriceInfo() {
    private var price1: Double = 1.0
    private var price2: Double = 2.0
    private val lock: ReadWriteLock = ReentrantReadWriteLock()

    public fun getPrice1(): Double {
        lock.readLock().lock()
        println("${Thread.currentThread().name} start read1")
        val price = price1
        println("${Thread.currentThread().name} end read1")
        lock.readLock().unlock()
        return price
    }

    public fun getPrice2(): Double {
        lock.readLock().lock()
        println("${Thread.currentThread().name} start read2")
        val price = price2
        println("${Thread.currentThread().name} end read2")
        lock.readLock().unlock()
        return price
    }

    public fun setPrices(price1: Double, price2: Double) {
        lock.writeLock().lock()
        println("${Thread.currentThread().name} start write")
        this.price1 = price1
        this.price2 = price2
        println("${Thread.currentThread().name} end write")
        lock.writeLock().unlock()
    }
}