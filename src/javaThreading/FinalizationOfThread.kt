package javaThreading

/**
 * Created by krishan on 08/04/18.
 */
fun main(args: Array<String>) {
    val thread1 = Thread1()
    val thread2 = Thread2()
    val thread3 = Thread3()

    thread1.start()
    thread2.start()
    thread3.start()
    println("before finalization")
    thread1.join() // suspending thread
    thread2.join(1000) // suspending thread for only one second
    thread3.join()
    println("finalization finished")
}

class Thread1 : Thread() {
    override fun run() {
        super.run()
        Thread.sleep(2000)
        println("Ending thread 1")
    }
}

class Thread2 : Thread() {
    override fun run() {
        super.run()
        Thread.sleep(4000)
        println("Ending thread 2")
    }
}

class Thread3 : Thread() {
    override fun run() {
        super.run()
        Thread.sleep(1000)
        println("Ending Thread 3")
    }
}

