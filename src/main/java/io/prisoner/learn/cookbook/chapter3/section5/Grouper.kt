package io.prisoner.learn.cookbook.chapter3.section5

/**
 * DATE: 2017/8/21 22:00 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Grouper(private val results: Results): Runnable {
    override fun run() {
        println("Grouper: Processing results")
        val data = results.getData()
        val finalResult = data.sumBy { it!! }
        println("Grouper: Total result: $finalResult")
    }
}