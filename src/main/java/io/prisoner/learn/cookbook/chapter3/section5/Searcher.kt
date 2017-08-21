package io.prisoner.learn.cookbook.chapter3.section5

import java.util.concurrent.BrokenBarrierException
import java.util.concurrent.CyclicBarrier

/**
 * DATE: 2017/8/21 22:00 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Searcher: Runnable {
    private var firstRow: Int
    private var lastRow: Int
    private val matrixMock: MatrixMock
    private val results: Results
    private val num: Int
    private final val barrier: CyclicBarrier

    constructor(firstRow: Int, lastRow: Int, mock: MatrixMock, results: Results,
                number: Int, barrier: CyclicBarrier) {

        this.firstRow = firstRow
        this.lastRow = lastRow
        this.matrixMock = mock
        this.results = results
        this.num = number
        this.barrier = barrier
    }

    override fun run() {
        var counter: Int
        println("${Thread.currentThread().name}: Processing lines from $firstRow to $lastRow")
        for (i in firstRow until  lastRow) {
            val row = matrixMock.getRow(i)
            if (null == row) {
                println(i)
            }
            counter = row!!.count { it == num }
            results.setData(i, counter)
        }
        println("${Thread.currentThread().name} Lines processed.")
        try {
            println("numberWaiting: ${barrier.numberWaiting}")
            barrier.await()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: BrokenBarrierException) {
            e.printStackTrace()
        }
    }
}