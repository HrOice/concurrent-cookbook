package io.prisoner.learn.cookbook.chapter2.section2

/**
 * DATE: 2017/8/20 19:46 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val account = Account()
    account.setBalance(1000.0)
    val bank = Bank(account)
    val company = Company(account)
    val thread1 = Thread(bank)
    val thread2 = Thread(company)
    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()
    println("the balance is ${account.getBalance()}")
}