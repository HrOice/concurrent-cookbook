package io.prisoner.learn.cookbook.chapter1.section12

import io.prisoner.learn.cookbook.chapter1.section9.ExceptionHandler


/**
 * DATE: 2017/8/19 16:43 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val myThreadGroup = MyThreadGroup("MyThreadGroup")
    val task = Task()
    for (i in 0..1) {
        val thread = Thread(myThreadGroup, task)
//        thread.uncaughtExceptionHandler = ExceptionHandler()
        thread.start()
    }
}