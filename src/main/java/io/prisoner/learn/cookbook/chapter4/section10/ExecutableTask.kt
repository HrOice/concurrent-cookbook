package io.prisoner.learn.cookbook.chapter4.section10

import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/24 23:46 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class ExecutableTask(private val name: String): Callable<String> {
    override fun call(): String {
        try {
            val duration = (Math.random() * 10).toLong()
            println("${name}: Waiting $duration seconds for results.")
            TimeUnit.SECONDS.sleep(duration)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return "Hello, world. I'm $name"
    }

    public fun getName(): String {
        return name
    }
}