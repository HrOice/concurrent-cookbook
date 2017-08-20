package io.prisoner.learn.cookbook.chapter2.section6

/**
 * DATE: 2017/8/20 21:52 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
fun main(args: Array<String>) {
    val priceInfo = PriceInfo()
    val readThreads = arrayOfNulls<Thread>(5)
    for (i in 0..4) {
        readThreads[i] = Thread(Reader(priceInfo))
    }
    val writeThread = Thread(Writer(priceInfo))
    for (i in 0..4) {
        readThreads[i]!!.start()
    }
    writeThread.start()
}



// when prices has been modified, the reader-threads will read different price
// one is before writing, another is after writing
// as we can see
// when the writeLock works, other threads readLock and writeLock can not work
// e.g.  there are not 'start read' or 'end read' between 'start write' and 'end write'
//Thread-5 start write
//Thread-1: Price 1: 1.0
//Thread-0: Price 1: 1.0
//Thread-5 end write

// but the readLock works, other threads works
// Thread-1 start read2
//Thread-4 start read2
//Thread-4 end read2
//Thread-0 start read2
//Thread-0 end read2
//Thread-4: Price 2: 5.993992811313321
//Thread-1 end read2




//Thread-5: Writer: Attempt to modify the prices.
//Thread-2: Price 1: 1.0
//Thread-3: Price 1: 1.0
//Thread-4: Price 1: 1.0
//Thread-5 start write
//Thread-1: Price 1: 1.0
//Thread-0: Price 1: 1.0
//Thread-5 end write
//Writer: Prices have been modified.
//Thread-2 start read
//Thread-2 end read
//Thread-2: Price 2: 5.937611740546822
//Thread-3 start read
//Thread-3 end read
//Thread-1 start read
//Thread-1 end read
//Thread-4 start read
//Thread-4 end read
//Thread-2: Price 1: 0.2734875685364291
//Thread-4: Price 2: 5.937611740546822
//Thread-1: Price 2: 5.937611740546822
//Thread-0 start read
//Thread-3: Price 2: 5.937611740546822
//Thread-0 end read
//Thread-1: Price 1: 0.2734875685364291
//Thread-4: Price 1: 0.2734875685364291
//Thread-2 start read
//Thread-2 end read
//Thread-4 start read
//Thread-4 end read
//Thread-1 start read
//Thread-1 end read
//Thread-0: Price 2: 5.937611740546822
//Thread-3: Price 1: 0.2734875685364291
//Thread-0: Price 1: 0.2734875685364291
//Thread-1: Price 2: 5.937611740546822
//Thread-4: Price 2: 5.937611740546822
//Thread-2: Price 2: 5.937611740546822
//Thread-4: Price 1: 0.2734875685364291
//Thread-1: Price 1: 0.2734875685364291
//Thread-0 start read
//Thread-0 end read
//Thread-3 start read
//Thread-3 end read
//Thread-0: Price 2: 5.937611740546822
//Thread-1 start read
//Thread-4 start read
//Thread-4 end read
//Thread-2: Price 1: 0.2734875685364291
//Thread-4: Price 2: 5.937611740546822
//Thread-1 end read
//Thread-4: Price 1: 0.2734875685364291
//Thread-0: Price 1: 0.2734875685364291
//Thread-3: Price 2: 5.937611740546822
//Thread-0 start read
//Thread-0 end read
//Thread-4 start read
//Thread-1: Price 2: 5.937611740546822
//Thread-2 start read
//Thread-1: Price 1: 0.2734875685364291
//Thread-1 start read
//Thread-5: Writer: Attempt to modify the prices.
//Thread-4 end read
//Thread-0: Price 2: 5.937611740546822
//Thread-3: Price 1: 0.2734875685364291
//Thread-4: Price 2: 5.937611740546822
//Thread-1 end read
//Thread-2 end read
//Thread-1: Price 2: 5.937611740546822
//Thread-2: Price 2: 5.937611740546822
//Thread-5 start write
//Thread-5 end write
//Writer: Prices have been modified.
//Thread-0: Price 1: 7.703930249155503
//Thread-0 start read
//Thread-1: Price 1: 7.703930249155503
//Thread-3 start read
//Thread-3 end read
//Thread-1 start read
//Thread-1 end read
//Thread-2: Price 1: 7.703930249155503
//Thread-0 end read
//Thread-4: Price 1: 7.703930249155503
//Thread-0: Price 2: 7.325683235772698
//Thread-2 start read
//Thread-1: Price 2: 7.325683235772698
//Thread-3: Price 2: 7.325683235772698
//Thread-1: Price 1: 7.703930249155503
//Thread-2 end read
//Thread-0: Price 1: 7.703930249155503
//Thread-4 start read
//Thread-4 end read
//Thread-0 start read
//Thread-2: Price 2: 7.325683235772698
//Thread-1 start read
//Thread-2: Price 1: 7.703930249155503
//Thread-3: Price 1: 7.703930249155503
//Thread-2 start read
//Thread-2 end read
//Thread-1 end read
//Thread-0 end read
//Thread-4: Price 2: 7.325683235772698
//Thread-0: Price 2: 7.325683235772698
//Thread-1: Price 2: 7.325683235772698
//Thread-0: Price 1: 7.703930249155503
//Thread-2: Price 2: 7.325683235772698
//Thread-3 start read
//Thread-3 end read
//Thread-2: Price 1: 7.703930249155503
//Thread-0 start read
//Thread-0 end read
//Thread-1: Price 1: 7.703930249155503
//Thread-0: Price 2: 7.325683235772698
//Thread-4: Price 1: 7.703930249155503
//Thread-0: Price 1: 7.703930249155503
//Thread-1 start read
//Thread-1 end read
//Thread-5: Writer: Attempt to modify the prices.
//Thread-2 start read
//Thread-2 end read
//Thread-3: Price 2: 7.325683235772698
//Thread-2: Price 2: 7.325683235772698
//Thread-1: Price 2: 7.325683235772698
//Thread-0 start read
//Thread-0 end read
//Thread-0: Price 2: 7.325683235772698
//Thread-4 start read
//Thread-4 end read
//Thread-5 start write
//Thread-5 end write
//Thread-4: Price 2: 7.325683235772698
//Writer: Prices have been modified.
//Thread-3: Price 1: 6.099088050491853
//Thread-4: Price 1: 6.099088050491853
//Thread-1: Price 1: 6.099088050491853
//Thread-3 start read
//Thread-3 end read
//Thread-2: Price 1: 6.099088050491853
//Thread-3: Price 2: 0.8351017635773843
//Thread-1 start read
//Thread-0: Price 1: 6.099088050491853
//Thread-4 start read
//Thread-0 start read
//Thread-0 end read
//Thread-1 end read
//Thread-3: Price 1: 6.099088050491853
//Thread-2 start read
//Thread-2 end read
//Thread-3 start read
//Thread-1: Price 2: 0.8351017635773843
//Thread-0: Price 2: 0.8351017635773843
//Thread-4 end read
//Thread-0: Price 1: 6.099088050491853
//Thread-4: Price 2: 0.8351017635773843
//Thread-1: Price 1: 6.099088050491853
//Thread-3 end read
//Thread-2: Price 2: 0.8351017635773843
//Thread-3: Price 2: 0.8351017635773843
//Thread-1 start read
//Thread-1 end read
//Thread-4: Price 1: 6.099088050491853
//Thread-0 start read
//Thread-0 end read
//Thread-0: Price 2: 0.8351017635773843
//Thread-0: Price 1: 6.099088050491853
//Thread-0 start read
//Thread-0 end read
//Thread-0: Price 2: 0.8351017635773843
//Thread-0: Price 1: 6.099088050491853
//Thread-4 start read
//Thread-4 end read
//Thread-1: Price 2: 0.8351017635773843
//Thread-3: Price 1: 6.099088050491853
//Thread-2: Price 1: 6.099088050491853
//Thread-3 start read
//Thread-3 end read
//Thread-1: Price 1: 6.099088050491853
//Thread-4: Price 2: 0.8351017635773843
//Thread-0 start read
//Thread-4: Price 1: 6.099088050491853
//Thread-1 start read
//Thread-1 end read
//Thread-3: Price 2: 0.8351017635773843
//Thread-2 start read
//Thread-3: Price 1: 6.099088050491853
//Thread-2 end read
//Thread-1: Price 2: 0.8351017635773843
//Thread-4 start read
//Thread-4 end read
//Thread-0 end read
//Thread-4: Price 2: 0.8351017635773843
//Thread-1: Price 1: 6.099088050491853
//Thread-2: Price 2: 0.8351017635773843
//Thread-3 start read
//Thread-2: Price 1: 6.099088050491853
//Thread-1 start read
//Thread-1 end read
//Thread-4: Price 1: 6.099088050491853
//Thread-0: Price 2: 0.8351017635773843
//Thread-4 start read
//Thread-4 end read
//Thread-1: Price 2: 0.8351017635773843
//Thread-2 start read
//Thread-2 end read
//Thread-3 end read
//Thread-2: Price 2: 0.8351017635773843
//Thread-2: Price 1: 6.099088050491853
//Thread-2 start read
//Thread-4: Price 2: 0.8351017635773843
//Thread-2 end read
//Thread-4: Price 1: 6.099088050491853
//Thread-3: Price 2: 0.8351017635773843
//Thread-4 start read
//Thread-2: Price 2: 0.8351017635773843
//Thread-4 end read
//Thread-3: Price 1: 6.099088050491853
//Thread-4: Price 2: 0.8351017635773843
//Thread-2: Price 1: 6.099088050491853
//Thread-2 start read
//Thread-2 end read
//Thread-2: Price 2: 0.8351017635773843
//Thread-3 start read
//Thread-3 end read
//Thread-3: Price 2: 0.8351017635773843
//Thread-3: Price 1: 6.099088050491853
//Thread-3 start read
//Thread-3 end read
//Thread-3: Price 2: 0.8351017635773843
//Thread-3: Price 1: 6.099088050491853
//Thread-3 start read
//Thread-3 end read
//Thread-3: Price 2: 0.8351017635773843