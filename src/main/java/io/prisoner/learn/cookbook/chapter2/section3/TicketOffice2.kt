package io.prisoner.learn.cookbook.chapter2.section3

/**
 * DATE: 2017/8/20 20:30 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class TicketOffice2(private val cinema: Cinema): Runnable {
    override fun run() {
        cinema.sellTickets2(2)
        cinema.sellTickets2(4)
        cinema.sellTickets1(2)
        cinema.sellTickets1(1)
        cinema.returnTickets2(2)
        cinema.sellTickets1(3)
        cinema.sellTickets2(2)
        cinema.sellTickets1(2)
    }
}