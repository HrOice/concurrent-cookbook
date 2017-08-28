package io.prisoner.learn.cookbook.chapter5.section6

import java.util.concurrent.ForkJoinTask

/**
 * DATE: 2017/8/28 21:51 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class TaskManager {
    private val tasks = ArrayList<ForkJoinTask<Int>>()

    public fun addTask(task: ForkJoinTask<Int>) {
        tasks.add(task)
    }

    public fun cancelTasks(cancelTask: ForkJoinTask<Int>) {
        for (task in tasks) {
            if (cancelTask != task)
                task.cancel(true)
            (task as SearchNumberTask).writeCancelMessage()
        }
    }
}