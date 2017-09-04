package io.prisoner.learn.extra

/**
 * DATE: 2017/9/1 00:29 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    println((-1).shl(Integer.SIZE -3))
    println(Integer.toBinaryString((-1).shl(Integer.SIZE -3)))
    println(Integer.toBinaryString((0).shl(Integer.SIZE -3)))
    println(Integer.toBinaryString((1).shl(Integer.SIZE -3) - 1))
    println(Integer.toBinaryString((2).shl(Integer.SIZE -3)))
    println(Integer.toBinaryString((3).shl(Integer.SIZE -3)))
}