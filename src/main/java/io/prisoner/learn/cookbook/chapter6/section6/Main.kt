package io.prisoner.learn.cookbook.chapter6.section6

import java.util.concurrent.ConcurrentNavigableMap
import java.util.concurrent.ConcurrentSkipListMap

/**
 * DATE: 2017/8/30 22:26 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val map = ConcurrentSkipListMap<String, Contact>()

    val threads = arrayOfNulls<Thread>(25)

    for ((counter, i) in ('A' until 'Z').withIndex()) {
        val task = Task(map, i.toString())
        threads[counter] = Thread(task)
        threads[counter]!!.start()
    }

    for (i in 0 until 25) {
        threads[i]!!.join()
    }

    println("Main: Size of the map: ${map.size}")

    var element = map.firstEntry()
    var concat = element.value
    println("Main: First Entry: ${concat.name}: ${concat.phone}")

    element = map.lastEntry()
    concat = element.value
    println("Main: Last Entry: ${concat.name}: ${concat.phone}")

    val submap = map.subMap("A1996", "B1002") as ConcurrentNavigableMap<String, Contact>
    println("Main: Submap from A1996 to B1002")
    do {
        element = submap.pollFirstEntry()
        if (element != null) {
            concat = element.value
            println("${concat.name}: ${concat.phone}")
        }
    } while (element != null)


}