package javaThreading

import java.util.*

/**
 * Created by krishan on 08/04/18.
 */
fun main(args: Array<String>) {
    // useful when thread share same data available through an instance of a runnable
    // but u want something to be local for same instance of thread
    var runnable = DateTask()
    val threads = Array(5, { Thread(runnable) }) // each thread is sharing same runnable instance here
    for (i in 0 until 5) {
        Thread.sleep(1000)
        threads[i].start()
    }
}

class DateTask : Runnable {
    private var date: ThreadLocal<Date> = ThreadLocal()
    override fun run() {
        date.set(Date())
        println(" ${Thread.currentThread().id}-->${date.get()}") // should print same start and end date for on thread if it is local
        Thread.sleep(1000)
        println(" ${Thread.currentThread().id}-->${date.get()}")

    }

}