package io.prisoner.learn.cookbook.chapter5.section1

import java.util.concurrent.ForkJoinTask
import java.util.concurrent.RecursiveAction

/**
 * DATE: 2017/8/27 16:10 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task(private val products: List<Product>,
           private val first: Int,
           private val last: Int,
           private val increment: Double): RecursiveAction() {
    override fun compute() {
        if (last - first < 10) {
            updatePrices()
        } else {
            val middle = (first + last) / 2
            println("Task: Pending tasks: ${ForkJoinTask.getQueuedTaskCount()}")
            val t1 = Task(products, first, middle + 1, increment)
            val t2 = Task(products, middle + 1, last, increment)
            ForkJoinTask.invokeAll(t1, t2)
        }
    }

    private fun updatePrices() {
        (first until last)
                .map { products[it] }
                .forEach { it.price = it.price!! * (1 + increment) }
    }
}