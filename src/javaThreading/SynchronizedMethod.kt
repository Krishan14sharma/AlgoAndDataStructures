package javaThreading

/**
 * Created by krishan on 08/04/18.
 */
fun main(args: Array<String>) {
    val account = AccountSync(1000)
    val thread1 = Thread(BankSync(account))
    val thread2 = Thread(CompanySync(account))
    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
    print("${account.getBalance()} expected result was 1000")

}

class BankSync(var account: AccountSync) : Runnable {
    override fun run() {
        for (i in 0..100) {
            Thread.sleep(10)
            account.removeBalance()
        }

    }

}

class CompanySync(var account: AccountSync) : Runnable {
    override fun run() {
        for (i in 0..100) {
            Thread.sleep(10)
            account.addBalance()
        }
    }

}


class AccountSync(private var balance: Int) {

    fun getBalance(): Int {
        return balance
    }

    @Synchronized
    fun addBalance() {
        balance += 1000
    }

    @Synchronized
    fun removeBalance() {
        balance -= 1000
    }

}