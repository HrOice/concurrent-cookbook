package io.prisoner.learn.cookbook.chapter4.section1

import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

/**
 * DATE: 2017/8/23 22:12 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Server {
    private val executor: ThreadPoolExecutor
    constructor() {
        executor = Executors.newCachedThreadPool() as ThreadPoolExecutor
    }

    public fun executeTask(task: Task) {
        println("Server: A new Task has arrived.")
        executor.execute(task)
        println("Server: Pool size: ${executor.poolSize}")
        println("Server: Active Count: ${executor.activeCount}")
        println("Server: Completed tasks: ${executor.completedTaskCount}")

    }

    public fun endServer() {
        executor.shutdown()
    }
}