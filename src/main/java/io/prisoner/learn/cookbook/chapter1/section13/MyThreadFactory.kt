package io.prisoner.learn.cookbook.chapter1.section13

import java.util.*
import java.util.concurrent.ThreadFactory

/**
 * DATE: 2017/8/19 16:51 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyThreadFactory: ThreadFactory {
    private var counter: Int = 0
    private var name: String
    private var stats: MutableList<String>

    constructor(name: String) {
        this.name = name
        stats = ArrayList<String>()
    }


    override fun newThread(r: Runnable?): Thread {
        val thread = Thread(r, "$name-Thread-$counter")
        counter ++
        stats.add("Created thread ${thread.name} id: ${thread.id}, ${Date()}")
        return thread
    }

    public fun getStats(): String {
        val buffer = StringBuffer()
        val it = stats.iterator()
        while(it.hasNext()) {
            buffer.append(it.next())
            buffer.append("\n")
        }
        return buffer.toString()
    }
}