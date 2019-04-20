package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val intArray = intArrayOf(14, 4)
    maxProfit(intArray).print()
}

fun maxProfit(prices: IntArray): Int {

    if (prices.isEmpty()) {
        return 0
    }

    if (prices.size == 1) {
        return 0
    }
    val list = IntArray(prices.size - 1)
    for (i in 0 until prices.size - 1) {
        prices.copyOfRange(i + 1, prices.size).print()
        list[i] = prices.copyOfRange(i + 1, prices.size).max()!! - prices[i]
    }

    return if (list.max()!! > 0) list.max()!! else 0
}