package algorithms.dynamicProgramming

/**no of rabbits starts from one, human.So does the series
 * 1,1,2,3,5,8,13......and so on
 * Created by krishan on 03/04/18.
 */
fun main(args: Array<String>) {
    val n = 7
    val fibonacci = Fibonacci()
    val result = fibonacci at n
    println(result)
}

class Fibonacci {

    infix fun at(n: Int): Int {
        var first = 1
        var second = 1
        for (i in 3..n) {
            val result = first + second
            first = second
            second = result
        }
        return second
    }
}

