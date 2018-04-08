package algorithms.dynamicProgramming

import java.util.*

/**
 * Created by krishan on 03/04/18.
 */
fun main(args: Array<String>) {
    val input1 = "abcddefg"
    val input2 = "abmcg"

    println(longestCommonSubSequence(input1, input2))
}


fun longestCommonSubSequence(input1: String, input2: String): Int {
    val m = input1.length
    val n = input2.length
    val lcs = Array(m + 1, { IntArray(n + 1) })
    for (i in 1..m) {
        for (j in 1..n) {
            if (input1[i - 1] == input2[j - 1]) {
                lcs[i][j] = lcs[i - 1][j - 1] + 1
            } else {
                lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j])
            }
        }
    }
    print(Arrays.deepToString(lcs))
    return lcs[m][n]
}
