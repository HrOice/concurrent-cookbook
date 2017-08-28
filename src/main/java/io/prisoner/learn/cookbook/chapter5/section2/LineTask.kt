package io.prisoner.learn.cookbook.chapter5.section2

import java.util.concurrent.ForkJoinTask
import java.util.concurrent.RecursiveTask
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/27 16:57 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class LineTask(private val line: Array<String?>,
               private val start: Int,
               private val end: Int,
               private val word: String): RecursiveTask<Int>() {
    override fun compute(): Int? {
        var result: Int? = null
        if (end - start < 100) {
            result = count(line, start, end, word)
        } else {
            val mid = (end + start) / 2
            val t1 = LineTask(line, start, mid , word)
            val t2 = LineTask(line, mid, end, word)
            ForkJoinTask.invokeAll(t1, t2)
            try {
                result = groupResults(t1.get(), t2.get())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        return result
    }

    private fun count(line: Array<String?>, start: Int, end: Int, word: String): Int {
        val counter = (start until end).count { word == line[it] }
        TimeUnit.MILLISECONDS.sleep(100)
        return counter
    }

    private fun groupResults(number1: Int, number2: Int): Int {
        return number1 + number2
    }
}