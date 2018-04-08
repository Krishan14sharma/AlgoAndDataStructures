package algorithms.dynamicProgramming

import java.util.*

/**
 * Created by krishan on 04/04/18.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(2, 3, 5, 6) // needs to be sorted
    val n = 10
    print(coinChangePossibleWays(input, n))
}

fun coinChangePossibleWays(input: IntArray, n: Int): Int {
    val cc = IntArray(n + 1)
    cc[0] = 1
    for (i in 1..n) {
        var ways = 0
        var self = 0
        for (j in 0 until input.size) {
            val changeValue = input[j]
            if (i < changeValue) {
                break
            } else {
                ways += (cc[changeValue] + cc[i - changeValue])
            }
            if (changeValue == i) {
                self++
            }
        }
        cc[i] = ways / 2 + self
    }
    print(Arrays.toString(cc))
    return cc[n]
}
