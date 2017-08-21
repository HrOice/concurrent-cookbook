package io.prisoner.learn.cookbook.chapter3.section5

import java.util.concurrent.CyclicBarrier

/**
 * DATE: 2017/8/21 22:00 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val ROWS = 10000
    val NUMBERS = 1000
    val SEARCH = 5
    val PARTICIPANTS = 5
    val LINES_PARTICIPANT = 2000
    val mock = MatrixMock(ROWS, NUMBERS, SEARCH)
    val results = Results(ROWS)
    val grouper = Grouper(results)
    val barrier = CyclicBarrier(PARTICIPANTS, grouper)
    val searchers = arrayOfNulls<Searcher>(PARTICIPANTS)
    for (i in 0 until PARTICIPANTS) {
        searchers[i] = Searcher(i * LINES_PARTICIPANT, (i * LINES_PARTICIPANT) + LINES_PARTICIPANT, mock, results, SEARCH, barrier)
        Thread(searchers[i]).start()
    }
}