package leetcode

import kotlin.math.min


fun main(args: Array<String>) {
    val source = arrayListOf(10, 15, 20).toIntArray()
    minCostClimbingStairs(source).print()
}

fun minCostClimbingStairs(cost: IntArray): Int {
    if (cost.isEmpty()) {
        return 0
    } else if (cost.size == 1) {
        return cost[0]
    }
    val dp = IntArray(cost.size + 1)
    dp[0] = 0
    dp[1] = cost[0]
    for (i in 1 until cost.size) {
        dp[i + 1] = min(dp[i], dp[i - 1]) + cost[i]
    }
    dp.print()
    return min(dp[cost.size], dp[cost.size - 1])
}