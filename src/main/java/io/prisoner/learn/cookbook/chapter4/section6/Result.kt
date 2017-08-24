package io.prisoner.learn.cookbook.chapter4.section6

/**
 * DATE: 2017/8/23 23:39 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class Result {
    var name: String? = null
        get() {
            return field
        }
        set(name: String?) {
            field = name
        }


    var value: Int? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }
}