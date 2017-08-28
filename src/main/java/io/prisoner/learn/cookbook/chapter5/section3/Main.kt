package io.prisoner.learn.cookbook.chapter5.section3

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/27 18:55 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val pool = ForkJoinPool()
    val system = FolderProcessor("/var/log", ".log")
    var app = FolderProcessor("/Users/macbook/", ".log")
    val document = FolderProcessor("/Users/macbook/documents", "log")

    pool.execute(system)
    pool.execute(app)
    pool.execute(document)

    do {
        println("******************************************")
        println("Main: p : ${pool.parallelism}")
        println("Main: active threads : ${pool.activeThreadCount}")
        println("Main: task count : ${pool.queuedTaskCount}")
        println("Main: steal : ${pool.stealCount}")
        println("******************************************")
        TimeUnit.SECONDS.sleep(1)
    } while (!system.isDone || !app.isDone || !document.isDone)

    pool.shutdown()

    var results: List<String> = ArrayList<String>()
    results = system.join()
    println("system ${results.size}")
    results = app.join()
    println("app ${results.size}")
    results = document.join()
    println("document ${results.size}")
}