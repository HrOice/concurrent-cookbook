package io.prisoner.learn.cookbook.chapter2.section2

/**
 * DATE: 2017/8/20 19:45 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Company(val account: Account): Runnable {
    override fun run() {
        for (i in 0..99) {
            account.addAmount(1000.0)
        }
    }
}