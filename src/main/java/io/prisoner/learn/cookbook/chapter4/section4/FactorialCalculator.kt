package io.prisoner.learn.cookbook.chapter4.section4

import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/23 22:54 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class FactorialCalculator(private val num: Int): Callable<Int> {
    override fun call(): Int {
        var result = 1
        if (num == 0 || num == 1) {
            return 1
        } else {
            for (i in 2 until num) {
                result *= i
                TimeUnit.MILLISECONDS.sleep(20)
            }
            println("${Thread.currentThread().name}: result")
        }
        return result
    }
}