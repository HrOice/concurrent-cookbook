package io.prisoner.learn.cookbook.chapter7.section7

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.ForkJoinWorkerThread

/**
 * DATE: 2017/9/3 17:01 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyWorkerThreadFactory: ForkJoinPool.ForkJoinWorkerThreadFactory {
    override fun newThread(pool: ForkJoinPool?): ForkJoinWorkerThread {
        return MyWorkedThread(pool!!)
    }
}