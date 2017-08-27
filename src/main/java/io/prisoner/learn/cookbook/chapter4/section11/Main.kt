package io.prisoner.learn.cookbook.chapter4.section11

import java.util.concurrent.*

/**
 * DATE: 2017/8/26 19:42 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val executor = Executors.newCachedThreadPool() as ExecutorService
    val service = ExecutorCompletionService<String>(executor)
    val faceRequest = ReportRequest("Face", service)
    val onlineRequest = ReportRequest("online", service)
    val faceThread = Thread(faceRequest)
    val onlineThread = Thread(onlineRequest)

    val processor = ReportProcessor(service)
    val pThread = Thread(processor)

    println("Main: Starting the Threads.")
    faceThread.start()
    onlineThread.start()
    pThread.start()

    println("Main: Waiting for the report generators.")
    faceThread.join()
    onlineThread.join()

    println("Main: Shutting down the executor.")
    executor.shutdown()

    executor.awaitTermination(1, TimeUnit.DAYS)

    processor.end = true
    println("Main: End")
}