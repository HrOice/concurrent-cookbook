package io.prisoner.learn.cookbook.chapter1.section7

import java.util.*

/**
 * DATE: 2017/8/18 23:30 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val dataSourceLoader = DataSourceLoader()
    val netConnectionsLoader = NetConnectionsLoader()
    val t1 = Thread(dataSourceLoader, "DateSource")
    val t2 = Thread(netConnectionsLoader, "NetConnection")
    t1.start()
    t2.start()
    try {
        // main thread has been held on
        t1.join()
        t2.join()
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
    println("Main: Configuration has been loaded: ${Date()}")
}