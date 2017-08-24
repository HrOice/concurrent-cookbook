package io.prisoner.learn.cookbook.chapter4.section3

/**
 * DATE: 2017/8/23 22:13 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val server = Server()
    for (i in 0 until 100) {
        server.executeTask(Task("Task $i"))
    }
    server.endServer()
}