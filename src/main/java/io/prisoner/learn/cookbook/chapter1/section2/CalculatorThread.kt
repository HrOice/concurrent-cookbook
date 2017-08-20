package io.prisoner.learn.cookbook.chapter1.section2

/**
 * DATE: 2017/8/17 23:48 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class CalculatorThread(private val num: Int) : Runnable {
    override fun run() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var i = 0
        while (i < 10) {
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().name, num, i, num * i)
            i++
        }
    }
}

fun main(args: Array<String>) {
    var i = 1;
    while (i < 10) {
        val caculartorThread: CalculatorThread = CalculatorThread(i)
        val thread: Thread = Thread(caculartorThread)
        thread.start()
        i ++
    }
}