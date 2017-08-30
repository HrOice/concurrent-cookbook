package io.prisoner.learn.cookbook.chapter6.section8

/**
 * DATE: 2017/8/30 23:07 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val account = Account()
    account.setBalance(1000)
    val bThread = Thread(Bank(account))
    val cThread = Thread(Company(account))

    println(account.getBalance())
    bThread.start()
    cThread.start()
    bThread.join()
    cThread.join()
    println(account.getBalance())
}