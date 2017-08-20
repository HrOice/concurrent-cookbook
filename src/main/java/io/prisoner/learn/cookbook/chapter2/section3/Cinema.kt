package io.prisoner.learn.cookbook.chapter2.section3

import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * DATE: 2017/8/20 20:14 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Cinema {
    private var vacanciesCinema1: Long
    private var vacanciesCinema2: Long
    private var controlCinema1: Any
    private var controlCinema2: Any
    constructor() {
        vacanciesCinema1 = 20
        vacanciesCinema2 = 20
        controlCinema1 = Object()
        controlCinema2 = Object()
    }
    
    public fun sellTickets1(number: Int): Boolean {
        synchronized(controlCinema1) {
            println("c1 start $number")
            Thread.sleep(10)
            return if (number < vacanciesCinema1) {
                vacanciesCinema1 -= number
                println("c1 end")
                true
            } else {
                println("c1 end")
                false
            }
        }
    }

    public fun sellTickets2(number: Int): Boolean {
        synchronized(controlCinema2) {
            //(c1 start - c2 start - c1 end - c2 end) can bee shown
            //sellTickets1() and sellTickets2 can be called on Concurrent

            println("c2 start $number")
            Thread.sleep(10)
            return if (number < vacanciesCinema2) {
                vacanciesCinema2 -= number
                println("c2 end")
                true
            } else {
                println("c2 end")
                false
            }
        }
    }

    public fun returnTickets1(number: Int): Boolean {
        synchronized(controlCinema1) {
            println("r1 start")
            Thread.sleep(10)
            vacanciesCinema1 += number
            println("r1 end")
            return true
        }
    }

    public fun returnTickets2(number: Int): Boolean {
        synchronized(controlCinema2) {
            println("r2 start")
            Thread.sleep(10)
            vacanciesCinema2 += number
            println("r2 end")
            return true
        }
    }

    public fun getVacanciesCinema1(): Long {
        return vacanciesCinema1
    }

    public fun getVacanciesCinema2(): Long {
        return vacanciesCinema2
    }

}