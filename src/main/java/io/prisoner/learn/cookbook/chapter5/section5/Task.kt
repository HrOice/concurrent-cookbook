package io.prisoner.learn.cookbook.chapter5.section5

import java.util.concurrent.ForkJoinTask
import java.util.concurrent.RecursiveTask
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/28 21:23 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task(private val array: Array<Int?>,
           private val start: Int,
           private val end: Int): RecursiveTask<Int>() {
    override fun compute(): Int {
        println("Task: Start from $start to $end.")
        if (end - start < 10) {
            if (start < 3 && 3 < end) {
                throw RuntimeException("This task throws an Exception: Task from $start to $end.")

            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        } else {
            val mid = (end + start) /2
            val task = Task(array, start, mid)
            val task2 = Task(array, mid, end)
            ForkJoinTask.invokeAll(task, task2)
        }
        println("Task: End from $start to $end.")
        return 0
    }
}