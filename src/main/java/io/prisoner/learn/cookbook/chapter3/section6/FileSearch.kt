package io.prisoner.learn.cookbook.chapter3.section6

import java.io.File
import java.util.*
import java.util.concurrent.Phaser
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/21 22:56 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class FileSearch(private val initPath: String, private val end: String, private val phaser: Phaser): Runnable {
    private var result: MutableList<String>
    init {
        result = ArrayList()
    }

    private fun directoryProcess(file: File) {
        val list = file.listFiles()
        if (null != list) {
            for (i in 0 until list.size) {
                if (list[i].isDirectory) {
                    directoryProcess(list[i])
                } else {
                    fileProcess(list[i])
                }
            }
        }
    }

    private fun fileProcess(file: File) {
        if (file.name.endsWith(end)) {
            result.add(file.absolutePath)
        }
    }

    private fun filterResults() {
        val newResults: MutableList<String> = ArrayList()
        val actualDate = Date().time
        for (i in 0 until result.size) {
            val file: File = File(result[i])
            val fileDate = file.lastModified()
            if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                newResults.add(result[i])
            }
        }
        result = newResults
    }

    private fun checkResults(): Boolean {
        if (result.isEmpty()) {
            println("${Thread.currentThread().name} Phase ${phaser.phase}: 0 results")
            println("${Thread.currentThread().name} Phase ${phaser.phase}: end")
//            println("${Thread.currentThread().name} Phase ${phaser.phase}: before ${phaser.arrive()}")
            phaser.arriveAndDeregister()
//            println("${Thread.currentThread().name} Phase ${phaser.phase}: after ${phaser.arrive()}")
            return false
        } else {
            println("${Thread.currentThread().name} Phase ${phaser.phase}: ${result.size} results")
            phaser.arriveAndAwaitAdvance()
            return true
        }

    }

    private fun showInfo() {
        for (i in 0 until result.size) {
            val file = File(result[i])
            println("${Thread.currentThread().name}: ${file.absolutePath}")
        }
        phaser.arriveAndAwaitAdvance()
    }

    override fun run() {
        phaser.arriveAndAwaitAdvance()
        println("${Thread.currentThread().name}: Starting")
        val file = File(initPath)
        if (file.isDirectory) {
            directoryProcess(file)
        }

        if (!checkResults()) {
            return
        }

        filterResults()

        if (!checkResults()) {
            return
        }

        showInfo()
        phaser.arriveAndDeregister()
//        phaser.arriveAndAwaitAdvance()
        println("${Thread.currentThread().name}: Work completed")
//        phaser.arriveAndDeregister()
    }
}