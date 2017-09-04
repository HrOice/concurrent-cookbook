package io.prisoner.learn.cookbook.chapter7.section5

import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/31 23:37 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyTask: Runnable {
    override fun run() {
        TimeUnit.SECONDS.sleep(2)
    }
}