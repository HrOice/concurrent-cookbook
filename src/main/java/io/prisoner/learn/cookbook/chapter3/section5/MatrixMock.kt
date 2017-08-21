package io.prisoner.learn.cookbook.chapter3.section5

import java.util.*

/**
 * DATE: 2017/8/21 21:59 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MatrixMock(size: Int, length: Int, number: Int) {
    private val data: Array<Array<Int?>>

    public fun getRow(row: Int): Array<Int?>? {
        if (row >= 0 && row < data.size) {
            return data[row]
        }
        return null
    }

    init {
        var counter = 0
        data = Array(size){ arrayOfNulls<Int>(length) }
        val random = Random()
        for (i in 0 until size) {
            for (j in 0 until length) {
                data[i][j] = random.nextInt(10)
                if (data[i][j] == number) {
                    counter ++
                }
            }
        }
        println("Mock: There are $counter ocurrences of number in generated data. $number")
    }

}