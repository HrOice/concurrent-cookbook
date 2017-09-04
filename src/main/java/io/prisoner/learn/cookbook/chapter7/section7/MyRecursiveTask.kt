package io.prisoner.learn.cookbook.chapter7.section7

import java.util.concurrent.ExecutionException
import java.util.concurrent.RecursiveTask
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/9/3 17:01 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyRecursiveTask(private val array: Array<Int?>,
                      private val start: Int,
                      private val end: Int): RecursiveTask<Int>() {
    override fun compute(): Int {
        var ret: Int
        val thread = Thread.currentThread() as MyWorkedThread
        thread.addTask()
        return 0
    }

    private fun addResults(task1: MyRecursiveTask, task2: MyRecursiveTask): Int {
        var value = 0
        value = try {
            task1.get() + task2.get()
        } catch (e: InterruptedException) {
            e.printStackTrace()
            0
        } catch (e: ExecutionException) {
            e.printStackTrace()
            0
        }

        TimeUnit.MILLISECONDS.sleep(10)
        return value
    }
}