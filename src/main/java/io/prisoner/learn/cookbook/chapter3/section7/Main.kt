package io.prisoner.learn.cookbook.chapter3.section7

/**
 * DATE: 2017/8/21 23:41 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val phaser = MyPhaser()
    val students = arrayOfNulls<Student>(5)
    for (i in 0 until 5) {
        students[i] = Student(phaser)
        phaser.register()
    }

    val threads = arrayOfNulls<Thread>(students.size)
    for (i in 0 until students.size) {
        threads[i] = Thread(students[i])
        threads[i]!!.start()
    }
    for (i in 0 until 5) {
        threads[i]!!.join()
    }

    println(phaser.isTerminated)
}