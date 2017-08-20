package io.prisoner.learn.cookbook.chapter1.section12

/**
 * DATE: 2017/8/19 16:37 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 * uncaughtException: current thread -> current threadGroup -> default
 */
class MyThreadGroup: ThreadGroup{

    constructor(name: String): super(name)

    override fun uncaughtException(t: Thread?, e: Throwable?) {
        println("Thread ${t!!.id} has thrown an Exception.")
        e!!.printStackTrace(System.out)
        println("Terminating the rest of the Threads.")
        interrupt()
    }
}