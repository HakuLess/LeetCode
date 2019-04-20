package leetcode.learn

import leetcode.print

fun main(args: Array<String>) {
    val intArray = intArrayOf(7,1,5,3,6,4)
    maxProfitFake(intArray).print()
}

fun maxProfitFake(prices: IntArray): Int {
    var result = 0

    val upArray = IntArray(prices.size)

    for (i in 0 until prices.size - 1) {
        upArray[i] = if (prices[i] <= prices[i + 1]) {
            1
        } else {
            -1
        }
    }

    upArray.print()

    var buyIndex: Int? = null
    upArray.forEachIndexed { index, value ->
        if (value > 0 && buyIndex == null) {
            buyIndex = index
        } else if (buyIndex != null && value <= 0) {
            result += prices[index] - prices[buyIndex!!]
            buyIndex = null
        }
    }
    return result
}