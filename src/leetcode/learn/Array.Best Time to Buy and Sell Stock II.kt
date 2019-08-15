package leetcode.learn

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val intArray = intArrayOf(7, 1, 5, 3, 6, 4)
    maxProfitAny(intArray).print()
}

fun maxProfitAny(prices: IntArray): Int {
    var max = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1])
            max += prices[i] - prices[i - 1]
    }
    return max
}