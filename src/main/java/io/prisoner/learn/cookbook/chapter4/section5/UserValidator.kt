package io.prisoner.learn.cookbook.chapter4.section5

import java.util.*
import java.util.concurrent.TimeUnit

/**
 * DATE: 2017/8/23 23:17 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class UserValidator(private val name: String) {
    public fun validate(name: String, password: String): Boolean {
        val random = Random()
        try {
            val duration = (Math.random() * 10).toLong()
            println("Validator ${this.name} : Validating a user during $duration")
            TimeUnit.SECONDS.sleep(duration)
        } catch (e: Exception) {
            return false
        }
        return random.nextBoolean()
    }

    public fun getName(): String {
        return name
    }
}