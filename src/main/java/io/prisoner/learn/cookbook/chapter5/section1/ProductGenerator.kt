package io.prisoner.learn.cookbook.chapter5.section1

/**
 * DATE: 2017/8/27 16:12 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class ProductGenerator {
    fun generater(size: Int): List<Product> {
        val ret = ArrayList<Product>()
        for (i in 0 until size) {
            val p = Product()
            p.name = "Product $i"
            p.price = 10.0
            ret.add(p)
        }
        return ret
    }
}