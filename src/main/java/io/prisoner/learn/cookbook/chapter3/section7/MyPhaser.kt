package io.prisoner.learn.cookbook.chapter3.section7

import java.util.concurrent.Phaser

/**
 * DATE: 2017/8/21 23:40 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyPhaser: Phaser() {
    //will be called on before invoking phaser.arriveAndAwaitAdvance()
    override fun onAdvance(phase: Int, registeredParties: Int): Boolean {
        return when(phase) {
            0 -> studentArrived()
            1 -> finishFirstExercise()
            2 -> finishSecondExercise()
            3 -> finishExam()
            else -> true
        }
    }

    private fun studentArrived(): Boolean {
        println("Phaser: The exam are going to start. The students are ready.")
        println("Phaser: We have $registeredParties students")
        return false
    }

    private fun finishFirstExercise(): Boolean {
        println("Phaser: All students have finish first exercise")
        println("Phaser: It's time for the second one")
        return false
    }

    private fun finishSecondExercise(): Boolean {
        println("Phaser: All students have finish secode exercise")
        println("Phaser: It's time for the third one")
        return false
    }

    private fun finishExam(): Boolean {
        println("Phaser: All the students have finished the exam.")
        println("Phaser: Thank you for your time")
        return true
    }
}