package io.prisoner.learn.cookbook.chapter2.section6

/**
 * DATE: 2017/8/20 21:50 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Writer(private val priceInfo: PriceInfo): Runnable {
    override fun run() {
        for (i in 0..2) {
            println("${Thread.currentThread().name}: Writer: Attempt to modify the prices.")
            priceInfo.setPrices(Math.random() * 10, Math.random() * 8)
            println("Writer: Prices have been modified.")
            try {
                Thread.sleep(2)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}