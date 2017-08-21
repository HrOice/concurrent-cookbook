package io.prisoner.learn.cookbook.chapter3.section6

import java.util.concurrent.Phaser

/**
 * DATE: 2017/8/21 22:56 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val phaser = Phaser(3)
    val f1 = FileSearch("/Users/macbook/MyPlans/thread", "iml", phaser)
    val f2 = FileSearch("/Users/macbook/Downloads", "xlsx", phaser)
    val f3 = FileSearch("/Users/macbook/Desktop", "sql", phaser)

    val t1 = Thread(f1, "F1")
    val t2 = Thread(f2, "F2")
    val t3 = Thread(f3, "F3")
    t1.start()
    t2.start()
    t3.start()
    t1.join()
    t2.join()
    t3.join()
    println(phaser.isTerminated)
}