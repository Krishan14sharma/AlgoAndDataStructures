package javaThreading

/**
 * Created by krishan on 08/04/18.
 */

fun main(args: Array<String>) {

    for (i in 0..10) {
        Thread(CalculatorRunnable()).start()
    }
}

class CalculatorRunnable : Runnable {

    var sum = 0

    override fun run() {
        for (i in 0..10) {
            sum += sum + i
        }
        println("${Thread.currentThread()} - $sum")
    }

}

