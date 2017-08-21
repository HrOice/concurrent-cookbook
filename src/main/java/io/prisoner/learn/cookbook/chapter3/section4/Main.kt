package io.prisoner.learn.cookbook.chapter3.section4

/**
 * DATE: 2017/8/21 21:28 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val videoconference = Videoconference(10)
    val vthread = Thread(videoconference)
    vthread.start()

    for (i in 0 until 10) {
        Thread(Participant(videoconference, "Participant: ${i}")).start()
    }
}