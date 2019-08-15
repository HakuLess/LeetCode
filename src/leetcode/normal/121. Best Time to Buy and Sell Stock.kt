package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val intArray = intArrayOf(14, 4)
    maxProfit(intArray).print()
}

fun maxProfit(prices: IntArray): Int {
    var min = Integer.MAX_VALUE
    var max = 0
    for (i in 0 until prices.size) {
        if (prices[i] < min)
            min = prices[i]
        else if (prices[i] - min > max)
            max = prices[i] - min
    }
    return max
}