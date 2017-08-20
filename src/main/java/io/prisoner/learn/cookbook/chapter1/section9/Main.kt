package io.prisoner.learn.cookbook.chapter1.section9

/**
 * DATE: 2017/8/19 13:38 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 * the process will be finished when an non-main thread throw an exception and the thread doesn't set uncaughtExceptionHandler
 * but the process will go on if it set.
 */
fun main(args: Array<String>) {
    val task = Task()
    val thread = Thread(task)
//    end
//    Thread: 10
//    Exception: class java.lang.NumberFormatException, For input string: "TTT"
//    Stack Trace
//            java.lang.NumberFormatException: For input string: "TTT"
//    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
//    at java.lang.Integer.parseInt(Integer.java:580)
//    at java.lang.Integer.parseInt(Integer.java:615)
//    at io.prisoner.learn.cookbook.chapter1.section9.Task.run(Task.kt:10)
//    at java.lang.Thread.run(Thread.java:745)
//    Thread status: RUNNABLE

//    thread.uncaughtExceptionHandler = ExceptionHandler()
    thread.start()
    println("end")
}