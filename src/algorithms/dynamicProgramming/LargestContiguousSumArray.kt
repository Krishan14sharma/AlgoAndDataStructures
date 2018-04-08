package algorithms.dynamicProgramming

/**
 * Created by krishan on 03/04/18.
 */

fun main(args: Array<String>) {
    val inputArray = intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3)
    print(largestContiguousSum(inputArray))
}

fun largestContiguousSum(inputArray: IntArray): Int {
    var max = 0
    var maxSofar = 0
    for (i in 0 until inputArray.size) {
        if (maxSofar + inputArray[i] > 0) {
            maxSofar += inputArray[i]
        } else {
            maxSofar = 0
        }
        if (maxSofar > max) {
            max = maxSofar
        }
    }
    return max
}
