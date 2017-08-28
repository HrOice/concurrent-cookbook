package io.prisoner.learn.cookbook.chapter5.section3

import java.io.File
import java.util.concurrent.RecursiveTask

/**
 * DATE: 2017/8/27 18:54 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class FolderProcessor(private val path :String,
                      private val extension: String): RecursiveTask<List<String>>() {
    override fun compute(): List<String> {
        val list = ArrayList<String>()
        val tasks = ArrayList<FolderProcessor>()

        val file = File(path)
        val content = file.listFiles()

        if (content != null) {
            for (i in 0 until content.size) {
                if (content[i].isDirectory) {
                    val task = FolderProcessor(content[i].absolutePath, extension)
                    task.fork()
                    tasks.add(task)
                } else {
                    if (content[i].name.endsWith(extension)) {
                        list.add(content[i].absolutePath)
                    }
                }
            }

            if (tasks.size > 50) {
                println("${file.absolutePath}: ${tasks.size} tasks ran")
            }

        }
        addResultFromTasks(list, tasks)
        return list

    }

    private fun addResultFromTasks(list: ArrayList<String>, tasks: List<FolderProcessor>) {
        for (item in tasks) {
            list.addAll(item.join())
        }
    }
}