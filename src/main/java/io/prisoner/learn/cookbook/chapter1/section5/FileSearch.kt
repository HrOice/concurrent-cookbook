package io.prisoner.learn.cookbook.chapter1.section5

import java.io.File

/**
 * DATE: 2017/8/18 21:13 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class FileSearch(val initPath: String, var fileName: String) : Runnable {
    override fun run() {
        val file = File(this.initPath)
        if (file.isDirectory) {
            try {
                directoryProcess(file)
            } catch (e: InterruptedException) {
                System.out.println("${Thread.currentThread().name}: The Search has been interrupted.")
            }
        }
    }

    private fun directoryProcess(file: File) {
        val files = file.listFiles()
        if (files.isNotEmpty()) {
            for (i in 0..files.size - 1) {
                if (files[i]!!.isDirectory) {
                    directoryProcess(files[i])
                } else {
                    fileProcess(files[i])
                }
            }
        }
        if (Thread.interrupted()) {
            throw InterruptedException()
        }
    }

    private fun fileProcess(file: File) {
        if (file.name == fileName) {
            System.out.println("${Thread.currentThread().name} : ${file.absolutePath}")
        }
        if (Thread.interrupted()) {
            throw InterruptedException()
        }
    }
}

fun main(args: Array<String>) {
    val fileSearch = FileSearch("/Users/macbook", "README.md")
    val thread = Thread(fileSearch)
    thread.start()
    try {
        Thread.sleep(10000)
    } catch (e: Exception ) {
        e.printStackTrace()
    }
    thread.interrupt()
}