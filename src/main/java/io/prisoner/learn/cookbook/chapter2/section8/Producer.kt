package io.prisoner.learn.cookbook.chapter2.section8

/**
 * DATE: 2017/8/20 23:24 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Producer(private val mock: FileMock, private val buffer: Buffer): Runnable {
    override fun run() {
        buffer.setPendingLines(true)
        while (mock.hasMoreLines()) {
            val  line = mock.getLine()
            buffer.insert(line)
        }
        buffer.setPendingLines(false)
    }
}