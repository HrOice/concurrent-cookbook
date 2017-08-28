package io.prisoner.learn.cookbook.chapter5.section6

import java.util.concurrent.RecursiveTask
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/28 21:51 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class SearchNumberTask(private val numbers: Array<Int?>,
                       private val start: Int,
                       private val end: Int,
                       private val number: Int,
                       private val manager: TaskManager): RecursiveTask<Int>() {
    private val NOT_FOUND = -1

    override fun compute(): Int {
        println("Task: $start: $end")
        return if (end -start > 10) {
            launchTasks()
        } else {
            lookForNumber()
        }
    }

    public fun writeCancelMessage() {
        println("Task: Cancelled task from $start to $end")

    }

    private fun launchTasks(): Int {
        val mid = (start + end) /2
        val t1 = SearchNumberTask(numbers, start, mid, number, manager)
        val t2 = SearchNumberTask(numbers, mid, end, number, manager)

        manager.addTask(t1)
        manager.addTask(t2)

        t1.fork()
        t2.fork()

        val returnValue = t1.join()
        if (returnValue != -1) {
            return returnValue
        }
        return t2.join()
    }

    private fun lookForNumber(): Int {
        for (i in start until end) {
            if (numbers[i] == number) {
                println("Task: Number $number found in position $i")
                manager.cancelTasks(this)
                return i
            }
            try {
                TimeUnit.SECONDS.sleep(1)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        return NOT_FOUND
    }
}