package io.prisoner.learn.cookbook.chapter7.section2

import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/30 23:40 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class SleepTwoSecondsTask: Callable<String> {
    override fun call(): String {
        TimeUnit.SECONDS.sleep(2)
        return Date().toString()
    }
}