package io.prisoner.learn.cookbook.chapter2.section6

/**
 * DATE: 2017/8/20 21:49 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Reader(private val priceInfo: PriceInfo): Runnable {
    override fun run() {
        for (i in 0..10) {
            println("${Thread.currentThread().name}: Price 1: ${priceInfo.getPrice1()}")
            println("${Thread.currentThread().name}: Price 2: ${priceInfo.getPrice2()}")
        }
    }
}
