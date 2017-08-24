package io.prisoner.learn.cookbook.chapter4.section5

import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

/**
 * DATE: 2017/8/23 23:18 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val username = "test"
    val password = "test";
    val ldpaValidator = UserValidator("ldpa")
    val dbValidator = UserValidator("DataBase")
    val ldpaTask = TaskValidator(ldpaValidator, username, password)
    val dbTask = TaskValidator(dbValidator, username, password)
    val taskList: MutableList<TaskValidator> = ArrayList()
    taskList.add(ldpaTask)
    taskList.add(dbTask)

    val executor = Executors.newCachedThreadPool() as ThreadPoolExecutor
    var result: String
    try {
        result = executor.invokeAny(taskList)
        println("result: ${result}")
    } catch (e: InterruptedException) {
        e.printStackTrace()
    } catch (e: ExecutionException) {
        e.printStackTrace()
    }
    executor.shutdown()
    println("END")
}