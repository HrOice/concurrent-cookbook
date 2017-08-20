package io.prisoner.learn.cookbook.chapter1.section13

import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/19 17:01 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Task: Runnable {
    override fun run() {
        TimeUnit.SECONDS.sleep(1)
    }
}