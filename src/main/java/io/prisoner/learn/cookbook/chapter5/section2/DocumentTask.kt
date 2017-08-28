package io.prisoner.learn.cookbook.chapter5.section2

import java.util.concurrent.ForkJoinTask
import java.util.concurrent.RecursiveTask

/**
 * DATE: 2017/8/27 16:56 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class DocumentTask(private val document: Array<Array<String?>>,
                   private val start: Int,
                   private val end: Int,
                   private val word: String): RecursiveTask<Int>() {
    override fun compute(): Int {
        var result = 0
        if (end - start < 10) {
            result = processLines(document, start, end, word)
        } else {
            val mid = (start + end) / 2
            val t1 = DocumentTask(document, start, mid + 1, word)
            val t2 = DocumentTask(document, mid + 1, end, word)
            ForkJoinTask.invokeAll(t1, t2)
            try {
                result = groupResults(t1.get(), t2.get())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        return result
    }

    private fun processLines(document: Array<Array<String?>>, start: Int, end: Int, word: String): Int {
        val tasks: MutableList<LineTask> = ArrayList()
        for (i in start until end) {
            val task = LineTask(document[i], 0, document[i].size, word)
            tasks.add(task)
        }
        ForkJoinTask.invokeAll(tasks)
        var result = 0
        for (t in tasks) {
            try {
                result += t.get()
//                println(result)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        return result
    }

    private fun groupResults(number1: Int, number2: Int): Int {
        return number1 + number2
    }
}