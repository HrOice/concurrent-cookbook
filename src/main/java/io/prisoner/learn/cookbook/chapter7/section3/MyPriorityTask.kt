package io.prisoner.learn.cookbook.chapter7.section3

import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/31 00:06 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyPriorityTask(private val priority: Int, private val name: String): Comparable<MyPriorityTask>, Runnable {
    override fun run() {
        println("MyPriorityTask: $name Priority $priority")
        TimeUnit.SECONDS.sleep(2)
    }

    override fun compareTo(other: MyPriorityTask): Int {
        return when {
            this.priority > other.priority -> 1
            this.priority < other.priority -> -1
            else -> 0
        }
    }
}