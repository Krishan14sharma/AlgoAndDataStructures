package javaThreading

/**
 * Created by krishan on 08/04/18.
 */
fun main(args: Array<String>) {
    val fileSearcher = FileSearcher()
    fileSearcher.start()
    Thread.sleep(5000)

    fileSearcher.interrupt()

}

class FileSearcher : Thread() {

    override fun run() {
        super.run()
        var notFound = true
        while (notFound) {
            if (isInterrupted) {
                // end execution of its work
                throw InterruptedException("Thread was interrupted")
            }
            Thread.sleep(1000)
            print("--")
        }

    }
}

