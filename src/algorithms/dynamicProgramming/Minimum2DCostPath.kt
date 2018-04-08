package algorithms.dynamicProgramming

import java.util.*

/**
 * Created by krishan on 03/04/18.
 */

fun main(args: Array<String>) {
    val row1 = intArrayOf(1, 2, 3)
    val row2 = intArrayOf(4, 8, 2)
    val row3 = intArrayOf(1, 5, 3)

    val input = arrayOf(row1, row2, row3)
    val coord1 = 2
    val coord2 = 2

    print(minimumCostPath(input, coord1, coord2))
}

fun minimumCostPath(input: Array<IntArray>, coord1: Int, coord2: Int): Int {
    val mcp = Array(3, { IntArray(3, fun(_): Int { return 0 }) })
    for (i in 0..coord1) {
        for (j in 0..coord2) {
            if (i == 0 && j == 0) {
                mcp[i][j] = input[i][j]
                continue
            }
            mcp[i][j] = Math.min(Math.min(getDiagonalCost(mcp, i, j), getTopCost(mcp, i, j))
                    , getleftCost(mcp, i, j)) + input[i][j]
        }
    }
    print(Arrays.deepToString(mcp))
    return mcp[coord1][coord2]
}

private fun getleftCost(mcp: Array<IntArray>, i: Int, j: Int) =
        if (j - 1 >= 0) mcp[i][j - 1] else Integer.MAX_VALUE

private fun getTopCost(mcp: Array<IntArray>, i: Int, j: Int) =
        if (i - 1 >= 0) mcp[i - 1][j] else Integer.MAX_VALUE

private fun getDiagonalCost(mcp: Array<IntArray>, i: Int, j: Int) =
        if (i - 1 >= 0 && j - 1 >= 0) mcp[i - 1][j - 1] else Integer.MAX_VALUE
