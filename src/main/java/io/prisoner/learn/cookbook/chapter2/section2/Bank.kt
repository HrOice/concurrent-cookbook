package io.prisoner.learn.cookbook.chapter2.section2

/**
 * DATE: 2017/8/20 19:44 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Bank(val account: Account): Runnable {
    override fun run() {
        for (i in 0..99) {
            account.subtractAmount(1000.0)
        }
    }
}