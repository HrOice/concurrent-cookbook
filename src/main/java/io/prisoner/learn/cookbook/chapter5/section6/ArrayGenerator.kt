package io.prisoner.learn.cookbook.chapter5.section6

import java.util.*

/**
 * DATE: 2017/8/28 21:51 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class ArrayGenerator {
    public fun generateArray(size: Int): Array<Int?> {
        val array = arrayOfNulls<Int>(size)
        val random = Random()
        for (i in 0 until size) {
            array[i] = random.nextInt(10)
        }
        return array
    }
}