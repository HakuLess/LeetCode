package leetcode

fun main(args: Array<String>) {
    val s = Solution309()
    s.maxProfit(intArrayOf(1, 2, 7, 4)).print()
//    s.maxProfit(intArrayOf(6, 1, 3, 2, 4, 7)).print()
//    s.maxProfit(intArrayOf(2, 1)).print()
}

class Solution309 {

    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }

        val n = prices.size
        val d = IntArray(n)
        for (i in 0 until n) {
            when (i) {
                0 -> d[0] = 0
                1 -> d[1] = maxOf(prices[1] - prices[0], 0)
                else -> {
                    d[i] = d[i - 1]
                    // linear scan
                    for (j in 0 until i) {
                        val prev = if (j >= 2) {
                            d[j - 2]
                        } else {
                            0
                        }
                        d[i] = maxOf(d[i], prev + prices[i] - prices[j])
                    }
                }
            }
        }

        return d[n - 1]
    }
//    fun maxProfit(prices: IntArray): Int {
//        if (prices.isEmpty()) {
//            return 0
//        }
//
//        val n = prices.size
//        val dp = Array(n) { IntArray(n) }
//
//        for (k in 0..n) {
//            for (i in 0 until n - k - 1) {
//                val j = i + k + 1
////                println("$i $j")
//                when {
//                    j - i == 1 -> dp[i][j] = prices[j] - prices[i]
//                    j - i == 2 -> dp[i][j] = maxOf(maxOf(dp[i][j - 1], dp[i + 1][j]), prices[j] - prices[i])
//                    else -> {
//                        for (m in i + 1..j - 2) {
//                            dp[i][j] = maxOf(dp[i][j], dp[i][m] + dp[m + 2][j])
//                        }
//                        dp[i][j] = maxOf(dp[i][j], prices[j] - prices[i])
//                        dp[i][j] = maxOf(dp[i][j], dp[i + 1][j])
//                        dp[i][j] = maxOf(dp[i][j], dp[i][j - 1])
//                    }
//                }
//            }
//        }
//
//        dp.forEach {
//            it.forEach {
//                print("$it, ")
//            }
//            println()
//        }
//
//        return if (dp[0][n - 1] > 0) dp[0][n - 1] else 0
//    }
}