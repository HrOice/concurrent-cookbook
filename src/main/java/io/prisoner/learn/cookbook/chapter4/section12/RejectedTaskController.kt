package io.prisoner.learn.cookbook.chapter4.section12

import java.util.concurrent.RejectedExecutionHandler
import java.util.concurrent.ThreadPoolExecutor

/**
 * DATE: 2017/8/27 15:26 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class RejectedTaskController: RejectedExecutionHandler {
    override fun rejectedExecution(r: Runnable?, executor: ThreadPoolExecutor?) {
        println("RejectedTaskController: The task ${r.toString()} has been rejected.")
        println("RejectedTaskController: ${executor.toString()}")
        println("RejectedTaskController: Terminating: ${executor!!.isTerminating}")
        println("RejectedTaskController: Terminated: ${executor!!.isTerminated}")
    }

}