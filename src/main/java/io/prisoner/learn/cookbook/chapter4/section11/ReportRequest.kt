package io.prisoner.learn.cookbook.chapter4.section11

import java.util.concurrent.CompletionService

/**
 * DATE: 2017/8/26 19:42 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class ReportRequest(private val name: String, private val service: CompletionService<String>): Runnable {
    override fun run() {
        val reportGenerator = ReportGenerator(name, "Report")
        service.submit(reportGenerator)
    }
}