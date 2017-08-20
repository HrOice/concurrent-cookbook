package io.prisoner.learn.cookbook.chapter2.section7

/**
 * DATE: 2017/8/20 21:25 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val printQueue = PrintQueueFair()
    val thread = arrayOfNulls<Thread>(10)
    for (i in 0..9) {
        thread[i] = Thread(JobFair(printQueue))
    }
    for (i in 0..9) {
        thread[i]!!.start()
        Thread.sleep(100)
    }
}

//Thread-0 start print a document.
//Thread-0 printing a job during: 8
//Thread-1 start print a document.
//Thread-2 start print a document.
//Thread-3 start print a document.
//Thread-4 start print a document.
//Thread-5 start print a document.
//Thread-6 start print a document.
//Thread-7 start print a document.
//Thread-1 printing a job during: 9
//Thread-8 start print a document.
//Thread-9 start print a document.
//Thread-2 printing a job during: 6
//Thread-3 printing a job during: 8
//Thread-4 printing a job during: 7
//Thread-5 printing a job during: 8
//Thread-6 printing a job during: 7
//Thread-7 printing a job during: 1
//Thread-0 printing a job during: 2 // why it's not 8 printing after 7 printing
//Thread-0 finish print a document. // because 8 get the lock after 0 print 800 ms
//Thread-8 printing a job during: 6 // 0 has join the second wait printing
//Thread-9 printing a job during: 9 // the wait time: 0 is longer than 8 (800ms)
//Thread-1 printing a job during: 9
//Thread-1 finish print a document.
//Thread-2 printing a job during: 3
//Thread-2 finish print a document.
//Thread-3 printing a job during: 2
//Thread-3 finish print a document.
//Thread-4 printing a job during: 7
//Thread-4 finish print a document.
//Thread-5 printing a job during: 1
//Thread-5 finish print a document.
//Thread-6 printing a job during: 5
//Thread-6 finish print a document.
//Thread-7 printing a job during: 0
//Thread-7 finish print a document.
//Thread-8 printing a job during: 7
//Thread-8 finish print a document.
//Thread-9 printing a job during: 5
//Thread-9 finish print a document.