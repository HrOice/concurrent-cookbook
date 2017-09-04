package io.prisoner.learn.cookbook.chapter7.section7

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.ForkJoinWorkerThread

/**
 * DATE: 2017/9/3 17:00 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyWorkedThread(pool: ForkJoinPool): ForkJoinWorkerThread(pool) {
    private val taskCounter = ThreadLocal<Int>()

    override fun onStart() {
        super.onStart()
        println("MyWorkedThread $id: Initializing task counter")
        taskCounter.set(0)
    }

    override fun onTermination(exception: Throwable?) {
        println("MyWorkerThread $id counter ${taskCounter.get()}")
        super.onTermination(exception)
    }

    public fun addTask() {
        var counter = taskCounter.get().toInt()
        counter++
        taskCounter.set(counter)
    }
}