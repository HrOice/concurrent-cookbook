package io.prisoner.learn.cookbook.chapter7.section2

import java.util.*
import java.util.concurrent.*

/**
 * DATE: 2017/8/30 23:39 <br>
 * MAIL: lbw@terminus.io <br>
 * AUTHOR: macbook
 */
class MyExecutor(corePoolSize: Int,
                 maxPoolSize: Int,
                 keepAliveTime: Long,
                 unit: TimeUnit,
                 workQueue: BlockingQueue<Runnable>):
        ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                keepAliveTime,
                unit,
                workQueue) {
    private val startTimes: ConcurrentHashMap<String, Date> = ConcurrentHashMap()

    override fun shutdown() {
        println("MyExecutor: Going to shutdown.")
        println("MyExecutor: Executed Tasks: $completedTaskCount")
        println("MyExecutor: Running Tasks: $activeCount")
        println("MyExecutor: Waiting Tasks: ${queue.size}")
//        super.shutdown()
        super.shutdownNow()
    }

    override fun shutdownNow(): MutableList<Runnable> {
        println("MyExecutor: Going to immediately shutdown.")
        println("MyExecutor: Executed Tasks: $completedTaskCount")
        println("MyExecutor: Running Tasks: $activeCount")
        println("MyExecutor: Waiting Tasks: ${queue.size}")
        return super.shutdownNow()
    }

    override fun beforeExecute(t: Thread?, r: Runnable?) {
        println("MyExecutor: A task is beginning: ${t!!.name}: ${r!!.hashCode()}")
        startTimes.put(r.hashCode().toString(), Date())
    }

    override fun afterExecute(r: Runnable?, t: Throwable?) {
        val result = r as Future<*>
        try {
            println("**********************************************")
            println("MyExecutor: A task is finishing.")
            println("MyExecutor: Result: ${result.get()}")
            val startDate: Date? = startTimes.remove(r.hashCode().toString())
            val diff = Date().time - startDate!!.time
            println("MyExecutor: Duration: ${diff}")
            println("**********************************************")
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        }
    }
}