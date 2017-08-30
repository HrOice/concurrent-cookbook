package io.prisoner.learn.cookbook.chapter6.section2

import java.util.concurrent.ConcurrentLinkedDeque

/**
 * DATE: 2017/8/29 22:28 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val list = ConcurrentLinkedDeque<String>()
    val addTasks = arrayOfNulls<Thread>(100)

    for (i in 0 until addTasks.size) {
        val task = AddTask(list)
        addTasks[i] = Thread(task)
        addTasks[i]!!.start()
    }

    println("Main: ${addTasks.size} AddTask threads have been launched.")

    for (task in addTasks) {
        task!!.join()
    }
    println("Main: Size of the List: ${list.size}")

    for (i in 0 until 100) {
        val task = PollTask(list)
        addTasks[i] = Thread(task)
        addTasks[i]!!.start()
    }
    println("Main: ${addTasks.size} poolTask threads have been launched")
    for(task in addTasks) {
        task!!.join()
    }

    println("Main: Size of the List: ${list.size}")
}