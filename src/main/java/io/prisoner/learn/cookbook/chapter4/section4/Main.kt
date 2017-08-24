package io.prisoner.learn.cookbook.chapter4.section4

import java.util.*
import java.util.concurrent.*

/**
 * DATE: 2017/8/23 22:54 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val executor = Executors.newFixedThreadPool(2) as ThreadPoolExecutor
    val resultList: MutableList<Future<Int>> = ArrayList()
    val random = Random()
    for (i in 0 until 10) {
        val number = random.nextInt(10)
        val calculator = FactorialCalculator(number)
        val result = executor.submit(calculator)
        resultList.add(result)
    }

    do {
        println("Main: Number of Completed tasks: ${executor.completedTaskCount}")
        for (i in 0 until resultList.size) {
            val result = resultList[i]
            println("Main: Task $i: ${result.isDone}")
        }
        try {
            TimeUnit.MILLISECONDS.sleep(50)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    } while (executor.completedTaskCount < resultList.size)
    println("Main: result:")
    for (i in 0 until resultList.size) {
        val result = resultList[i]
        var number: Int
        try {
            number = result.get()
            println("Task: ${i}: ${number}")
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        }
    }
    executor.shutdown()

}