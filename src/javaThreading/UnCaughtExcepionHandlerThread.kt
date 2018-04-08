package javaThreading

import java.io.FileNotFoundException
import kotlin.concurrent.thread

/**
 * Created by krishan on 08/04/18.
 */
fun main(args: Array<String>) {

    // for all the threads this is the default handler
    // have to be set before all the threads are executed
    //captures exception for threads that don't have handlers
    Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
        println("hurray caught the exception")
    }
    thread {
        Integer.parseInt("Crash")
    }.start()

    Thread(ExceptionRunnable()).also {
        it.uncaughtExceptionHandler = Thread.UncaughtExceptionHandler { _, p1 ->
            if (p1 is FileNotFoundException) {
                println("file was not found")
            }
        }
    }.start()


}

class ExceptionRunnable : Runnable {
    override fun run() {
        throw FileNotFoundException("File was not found")
    }

}

