package io.prisoner.learn.cookbook.chapter4.section10

import java.util.concurrent.Callable
import java.util.concurrent.FutureTask

/**
 * DATE: 2017/8/24 23:46 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class ResultTask(callable: Callable<String>) : FutureTask<String>(callable) {
    private val name: String?

    override fun done() {
        if (isCancelled) {
            println("$name has been canceled.")
        } else {
            println("$name has finished.")
        }
    }

    init {
        this.name = (callable as ExecutableTask).getName()
    }
}