package io.prisoner.learn.cookbook.chapter1.section3

import java.io.FileWriter
import java.io.PrintWriter

/**
 * DATE: 2017/8/18 00:09 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class CalculatorThread(private var num: Int) : Runnable{
    override fun run() {
        var i = 0
        while (i < 10) {
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().name, num, i, num * i)
            i++
        }
    }
}

fun main(args: Array<String>) {
    val threads = arrayOfNulls<Thread>(10)
    val states = arrayOfNulls<Thread.State>(10)

    for (i in 0..9) {
        threads[i] = Thread(CalculatorThread(i))
        if (i >= 5) {
            threads[i]!!.priority = Thread.MAX_PRIORITY
        } else {
            threads[i]!!.priority = Thread.MIN_PRIORITY
        }
        threads[i]!!.name = "Thread" + i
    }

    try {
        val fileWriter = FileWriter("./log.txt")
        val printWriter = PrintWriter(fileWriter)
        for (i in 0..9) {
            printWriter.println("Main : Status of Thread $i: ${threads[i]!!.state} ")
            states[i] = threads[i]!!.state
        }
        for (i in 0..9) {
            threads[i]!!.start()
        }
        var finish = false
        while(!finish) {
            (0..9)
                    .filter { threads[it]!!.state != states[it] }
                    .forEach {
                        //todo 写入文件
                        writeThreadInfo(printWriter, threads[it] as Thread, states[it] as Thread.State)
                        states[it] = threads[it]!!.state
                    }
            finish = true
            (0..9).forEach {
                finish = finish && (threads[it]!!.state == Thread.State.TERMINATED)
            }
            printWriter.print("      ")
        }
        printWriter.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun writeThreadInfo(pw: PrintWriter, thread: Thread, state: Thread.State) {
    pw.print("Main : Id ${thread.id} - ${thread.name}\n")
    pw.print("Main : Priority: ${thread.priority}\n")
    pw.print("Main : Old State: $state\n")
    pw.print("Main : New State: ${thread.state}\n")
    pw.print("Main : ***************************************\n")
}