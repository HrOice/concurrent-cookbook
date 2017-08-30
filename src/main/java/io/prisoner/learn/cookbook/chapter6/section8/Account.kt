package io.prisoner.learn.cookbook.chapter6.section8

import java.util.concurrent.atomic.AtomicLong

/**
 * DATE: 2017/8/30 23:07 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Account() {
    private val balance: AtomicLong = AtomicLong()

    public fun getBalance(): Long {
        return this.balance.get()
    }

    public fun setBalance(balance: Long)  {
        this.balance.set(balance)
    }

    public fun addBalance(amount: Long) {
        this.balance.getAndAdd(amount)
    }

    public fun subBalance(amount: Long) {
        this.balance.getAndAdd(-amount)
    }
}