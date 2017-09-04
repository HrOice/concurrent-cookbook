package io.prisoner.learn.cookbook.chapter7.section5

import java.util.concurrent.ThreadFactory

/**
 * DATE: 2017/8/31 23:37 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyThreadFactory(private val prefix: String): ThreadFactory {
    private var counter = 1

    override fun newThread(r: Runnable?): Thread {
        val thread = MyThread(r!!, "$prefix-$counter")
        counter ++
        return thread
    }



}