package io.prisoner.learn.cookbook.chapter7.section4

/**
 * DATE: 2017/8/31 23:37 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val myFactory = MyThreadFactory("factory")
    val task = MyTask()
    val thread = myFactory.newThread(task)
    thread.start()
    thread.join()

    println("Main: Thread information")
    println(thread)
    println("Main: End")
}