package io.prisoner.learn.cookbook.chapter2.section3

/**
 * DATE: 2017/8/20 20:28 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class TicketOffice1(private val cinema: Cinema): Runnable{
    override fun run() {
        cinema.sellTickets1(3)
        cinema.sellTickets1(2)
        cinema.sellTickets2(2)
        cinema.returnTickets1(3)
        cinema.sellTickets1(5)
        cinema.sellTickets2(2)
        cinema.sellTickets2(2)
        cinema.sellTickets2(2)
    }
}