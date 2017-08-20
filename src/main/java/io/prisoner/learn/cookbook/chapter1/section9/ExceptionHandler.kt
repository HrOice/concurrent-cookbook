package io.prisoner.learn.cookbook.chapter1.section9

/**
 * DATE: 2017/8/19 13:33 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class ExceptionHandler: Thread.UncaughtExceptionHandler {
    override fun uncaughtException(t: Thread?, e: Throwable?) {
        println("An exception has been captured")
        println("Thread: ${t?.id}")
        println("Exception: ${e?.javaClass}, ${e?.message}")
        println("Stack Trace")
        e?.printStackTrace(System.out)
        println("Thread status: ${t?.state}")
    }
}

