package io.prisoner.learn.cookbook.chapter5.section2

import java.util.*
import kotlin.collections.ArrayList

/**
 * DATE: 2017/8/27 16:56 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class DocumentMock {
    private val words = arrayOf("the", "hello", "goodbye", "packt", "java", "thread", "pool", "random", "class", "main")

    public fun generateDocument(numLines: Int, numWords: Int, word: String): Array<Array<String?>> {
        var counter  = 0
        val document = Array(numLines, { arrayOfNulls<String>(numWords) })
        val random = Random()

        for (i in 0 until numLines) {
            for (j in 0 until numWords) {
                document[i][j] = words[random.nextInt(words.size)]
                if (document[i][j] == word) {
                    counter ++
                }
            }
        }
        println("Mock: gen ${counter}")
        return document
    }
}