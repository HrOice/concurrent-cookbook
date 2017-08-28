package io.prisoner.learn.cookbook.chapter5.section1

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/27 16:10 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val productGenerator = ProductGenerator()
    val products = productGenerator.generater(10000)

    val pool = ForkJoinPool()
    val task = Task(products, 0, products.size, 0.2)

    pool.execute(task)

    do {
        println("Main: Thread Count: ${pool.activeThreadCount}")
        println("Main: Thread Steal: ${pool.stealCount}")
        println("Main: Thread Parallelism: ${pool.parallelism}") //created threads num = cpu's cores size
        TimeUnit.MILLISECONDS.sleep(5)
    } while (!task.isDone)

    pool.shutdown()

    if (task.isCompletedAbnormally) {
        println("Main: Process has completed normally")
    }

    products
            .filter { it.price != 12.0 }
            .forEach { println("Product ${it.name}: ${it.price}") }

    println("Main: End of the program.")

}