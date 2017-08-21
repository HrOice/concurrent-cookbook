package io.prisoner.learn.cookbook.chapter3.section5

/**
 * DATE: 2017/8/21 21:59 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Results {
    private val data: Array<Int?>

    constructor(size: Int) {
        data = arrayOfNulls(size)
    }

    public fun setData(position: Int, value: Int) {
        data[position] = value
    }

    public fun getData(): Array<Int?> {
        return data
    }
}