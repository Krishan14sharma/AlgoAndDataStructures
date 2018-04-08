package javaThreading

/**
 * Created by krishan on 08/04/18.
 */
fun main(args: Array<String>) {
    val numberOfThreads = 10;
    val threads = Array(numberOfThreads, { Thread(Runnable { Thread.sleep(1000) }) })
    for (i in 0 until numberOfThreads) {
        threads[i].name = "thread $i"
        threads[i].start()
    }
    var count = 0
    while (count < numberOfThreads) {
        count = 0
        for (i in 0 until numberOfThreads) {
            println("${threads[i].name} ${threads[i].state}")
            if (threads[i].state == Thread.State.TERMINATED) {
                count++
            }
        }
    }

}