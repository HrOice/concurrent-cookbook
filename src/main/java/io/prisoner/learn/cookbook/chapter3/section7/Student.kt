package io.prisoner.learn.cookbook.chapter3.section7

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/21 23:41 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Student(private val phaser: MyPhaser): Runnable {
    override fun run() {
        println("${Thread.currentThread().name} has arrived to do the exam ${Date()}")
        phaser.arriveAndAwaitAdvance()
        println("${Thread.currentThread().name} first start ${Date()}")
        doExercise1()
        println("${Thread.currentThread().name} first end ${Date()}")
        phaser.arriveAndAwaitAdvance()
        println("${Thread.currentThread().name} second start ${Date()}")
        doExercise2()
        println("${Thread.currentThread().name} second end ${Date()}")
        phaser.arriveAndAwaitAdvance()
        println("${Thread.currentThread().name} third start ${Date()}")
        doExercise3()
        println("${Thread.currentThread().name} third end ${Date()}")
        phaser.arriveAndAwaitAdvance()
    }

    private fun doExercise1() {
        TimeUnit.SECONDS.sleep((Math.random() * 10).toLong())
    }

    private fun doExercise2() {
        TimeUnit.SECONDS.sleep((Math.random() * 10).toLong())
    }

    private fun doExercise3() {
        TimeUnit.SECONDS.sleep((Math.random() * 10).toLong())
    }
}