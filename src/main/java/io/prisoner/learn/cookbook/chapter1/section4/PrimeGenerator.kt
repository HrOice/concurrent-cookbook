package io.prisoner.learn.cookbook.chapter1.section4

/**
 * DATE: 2017/8/18 20:25 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 * create a prime number generator
 * Check whether the continuous number from 1 is a prime number and force the thread to interrupt after 5 seconds.
 */
class PrimeGenerator: Thread() {
    override fun run() {
        var num: Long = 1
        while (true) {
            if (isPrime(num)) {
                System.out.println("Number $num is Prime")
            }
            if (isInterrupted) {
                System.out.println("The PrimeGenerator has been interrupted.")
                return
            }
            num ++
        }
    }

    fun isPrime(num: Long): Boolean {
        if (num < 2) return true
        return (2..num-1).none { 0L == num % it }
    }

}

fun main(args: Array<String>) {
    val task = PrimeGenerator()
    task.start()
    Thread.sleep(5000)
    task.interrupt()
}


