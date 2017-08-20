package io.prisoner.learn.cookbook.chapter2.section8

/**
 * DATE: 2017/8/20 23:02 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class FileMock {
    private val content: Array<String?>
    private var index: Int

    constructor(size: Int, length: Int) {
        content = arrayOfNulls(size)
        for (i in 0 until size) {
            val buffer = StringBuilder()
            for (j in 0 until length) {
                val indice = (Math.random() * 255).toInt()
                buffer.append(indice.toChar())
            }
            content[i] = buffer.toString()
        }
        index = 0
    }

    public fun hasMoreLines(): Boolean {
        return index < content.size
    }

    public fun getLine(): String? {
        if (hasMoreLines()) {
            println("Mock getLine: ${content.size - index}")
            return content[index++]
        }
        return null
    }


}