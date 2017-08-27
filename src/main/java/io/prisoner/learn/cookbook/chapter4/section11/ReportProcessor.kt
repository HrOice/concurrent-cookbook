package io.prisoner.learn.cookbook.chapter4.section11

import java.util.concurrent.CompletionService
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/26 19:42 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class ReportProcessor(private val service: CompletionService<String>): Runnable {
    var end: Boolean = false
    override fun run() {
        while (!end) {
            try {
                val result = service.poll(20, TimeUnit.SECONDS) //block until timeout
//                val result = service.poll() //return null
//                println("ReportProcessor: $result")
//                val result = service.take() //block

                if (null != result) {
                    val report = result.get()
                    println("ReportReceiver: Report Received: $report")
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        println("ReportSender: End.")
    }
}