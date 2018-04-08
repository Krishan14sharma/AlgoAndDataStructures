package javaThreading

/**
 * Created by krishan on 08/04/18.
 */
fun main(args: Array<String>) {
    val account = Account(1000)
    val thread1 = Thread(Bank(account))
    val thread2 = Thread(Company(account))
    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
    print("${account.getBalance()} expected result was 1000")

}

class Bank(var account: Account) : Runnable {
    override fun run() {
        for (i in 0..100) {
            Thread.sleep(10)
            account.removeBalance()
        }

    }

}

class Company(var account: Account) : Runnable {
    override fun run() {
        for (i in 0..100) {
            Thread.sleep(10)
            account.addBalance()
        }
    }

}


class Account(private var balance: Int) {

    fun getBalance(): Int {
        return balance
    }

    fun addBalance() {
        balance += 1000
    }

    fun removeBalance() {
        balance -= 1000
    }

}