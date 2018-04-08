package algorithms.dynamicProgramming

import java.util.*

/**
 * Created by krishan on 04/04/18.
 */
fun main(args: Array<String>) {
    val length = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    val price = intArrayOf(1, 5, 8, 9, 10, 17, 17, 20)
    val lengthOfRod = 8
    print(bestPrice(length, price, lengthOfRod))

}

fun bestPrice(length: IntArray, price: IntArray, lengthOfRod: Int): Int {
    val bestPrice = IntArray(lengthOfRod + 1)
    for (i in 1..lengthOfRod) {
        var max = 0
        for (j in 0 until i) {
            max = Math.max(price[j] + bestPrice[i - j - 1], max)
        }
        bestPrice[i] = max
    }
    print(Arrays.toString(bestPrice))
    return bestPrice[lengthOfRod]
}
