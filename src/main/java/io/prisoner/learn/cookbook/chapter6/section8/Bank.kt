package io.prisoner.learn.cookbook.chapter6.section8

/**
 * DATE: 2017/8/30 23:07 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Bank(private val account: Account): Runnable {
    override fun run() {
        for (i in 0 until 10) {
            account.subBalance(1000)
        }
    }
}