package io.prisoner.learn.cookbook.chapter2.section3

/**
 * DATE: 2017/8/20 20:32 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val cinema = Cinema()
    val t1 = Thread(TicketOffice1(cinema))
    val t2 = Thread(TicketOffice2(cinema))
    t1.start()
    t2.start()
    t1.join()
    t2.join()
    println("Room 1 Vacancies: ${cinema.getVacanciesCinema1()}")
    println("Room 2 Vacancies: ${cinema.getVacanciesCinema2()}")
}