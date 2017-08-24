package io.prisoner.learn.cookbook.chapter4.section5

import java.util.concurrent.Callable

/**
 * DATE: 2017/8/23 23:18 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class TaskValidator(private val userValidator: UserValidator, private val name: String, private val password: String): Callable<String> {
    override fun call(): String {
        if (!userValidator.validate(name, password)) {
            println("${userValidator.getName()}: The user has not been found")
            throw Exception("Error validating user")
        }
        println("${userValidator.getName()}: The user has been found")
        return userValidator.getName()
    }
}