package javaThreading

/**
 * Created by krishan on 08/04/18.
 */
fun main(args: Array<String>) {
    val cinema = Cinema()
    val distributor = Distributor(cinema)
    val distributor2 = Distributor(cinema)
    distributor.start()
    distributor2.start()

    distributor.join()
    distributor2.join()
    print("${cinema.audi1Tickets} ${cinema.audi2Tickets}")
}

class Distributor(val cinema: Cinema) : Thread() {

    override fun run() {
        cinema.sellTicketAudi1()
        cinema.sellTicketAudi1()
        cinema.sellTicketAudi1()
        cinema.sellTicketAudi1()
        cinema.sellTicketAudi1()
        cinema.returnTicketAudi1()
        cinema.sellTicketAudi2()
        cinema.sellTicketAudi2()
        cinema.returnTicketAudi2()
    }
}


class Cinema {

    var audi1Tickets = 100
    var audi2Tickets = 100

    private val audi1 = Object()
    private val audi2 = Object()

    fun sellTicketAudi1() {
        synchronized(audi1) { audi1Tickets-- }
    }

    fun sellTicketAudi2() {
        synchronized(audi2) { audi2Tickets-- }
    }

    fun returnTicketAudi1() {
        synchronized(audi1) { audi1Tickets++ }
    }

    fun returnTicketAudi2() {
        synchronized(audi2) { audi2Tickets++ }
    }
}