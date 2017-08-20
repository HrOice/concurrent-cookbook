package io.prisoner.learn.cookbook.chapter2.section2

import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/20 19:38 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Account {
    private var balance: Double = 0.0
    fun setBalance(balance: Double) {
        this.balance = balance
    }

    fun getBalance(): Double {
        return this.balance
    }
    //any object's Critical-Section(non-static) can be called on at a same time
    public @Synchronized fun addAmount(amount: Double) {
        println("Start add")
        var tmp: Double = balance
        TimeUnit.MILLISECONDS.sleep(10)
        tmp += amount
        balance = tmp
        println("End add")
    }

    public @Synchronized fun subtractAmount(amount: Double) {
        println("Start sub")
        var tmp: Double = balance
        TimeUnit.MILLISECONDS.sleep(10)
        tmp -= amount
        balance = tmp
        println("End sub")
    }

}