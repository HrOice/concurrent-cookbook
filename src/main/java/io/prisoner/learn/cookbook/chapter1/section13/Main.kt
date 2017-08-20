package io.prisoner.learn.cookbook.chapter1.section13

/**
 * DATE: 2017/8/19 16:59 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val threadFactory = MyThreadFactory("myThreadFactory")
    val task = Task()
    var thread: Thread
    println("Starting the threads")
    for (i in 1..10) {
        thread = threadFactory.newThread(task)
        thread.start()
    }
    println("Factory stats:")
    println(threadFactory.getStats())
}