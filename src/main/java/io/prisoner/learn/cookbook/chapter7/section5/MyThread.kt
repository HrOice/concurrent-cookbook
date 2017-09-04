package io.prisoner.learn.cookbook.chapter7.section5

import java.lang.StringBuilder
import java.util.*

/**
 * DATE: 2017/8/31 23:37 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyThread(target: Runnable, name: String) : Thread(target, name) {

    private var creationDate: Date? = null
    private var startDate: Date? = null
    private var finishDate: Date? = null

    init {
        setCreationDate()
    }

    private fun setCreationDate() {
        this.creationDate = Date()
    }

    private fun setStartDate() {
        startDate = Date()
    }

    private fun setFinishDate() {
        finishDate = Date()
    }

    private fun getExecutionTime(): Long {
        return finishDate!!.time - startDate!!.time
    }

    override fun run() {
        setStartDate()
        super.run()
        setFinishDate()
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(name)
        sb.append(": ")
        sb.append(" Creation Date: ")
        sb.append(creationDate)
        sb.append(" Running time:")
        sb.append(getExecutionTime())
        sb.append(" Milliseconds")
        return sb.toString()
    }

}