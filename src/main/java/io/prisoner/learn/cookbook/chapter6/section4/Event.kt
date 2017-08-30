package io.prisoner.learn.cookbook.chapter6.section4

/**
 * DATE: 2017/8/29 22:57 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Event(val thread: Int, val priority: Int): Comparable<Event> {
    override fun compareTo(other: Event): Int {
        return when {
            this.priority > other.priority -> -1
            this.priority < other.priority -> 1
            else -> 0
        }
    }
}