package javaThreading

import java.util.*

/**
 * Created by krishan on 08/04/18.
 */
fun main(args: Array<String>) {
    val queue = ArrayDeque<Task>()
    val writerThread = Thread(WriterTask(queue))
    writerThread.start()
    Thread(RemoveTask(queue)).also { it.isDaemon = true }.start()
    Thread.sleep(4000)
    writerThread.interrupt()
    println("Main execution stops") // daemon thread will end automatically when all non daemon threads complete
    //gc is a daemon thread
}

data class Task(var name: String)

class WriterTask(private val queue: ArrayDeque<Task>) : Runnable {

    override fun run() {
        var count = 1000
        while (count <= 1000 || !Thread.interrupted()) {
            queue.addFirst(Task("Task $count"))
            count++
        }
        println("ending execution of writer task")
    }

}

class RemoveTask(private var queue: ArrayDeque<Task>) : Runnable {

    override fun run() {
        while (true) {
            if (!queue.isEmpty())
                queue.removeLast()
            print("--")
        }
    }

}