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
        val dp = Array(n) { IntArray(n) }
//        for (i in n - 2 downTo 0) {
//            for (j in i + 1 until n) {
//                println("$i $j")
//
//                when {
//                    j - i == 1 -> dp[i][j] = prices[j] - prices[i]
//                    j - i == 2 -> dp[i][j] = maxOf(maxOf(dp[i][j - 1], dp[i + 1][j]), prices[j] - prices[i])
//                    else -> {
//                        for (m in i + 1..j - 2) {
//                            dp[i][j] = maxOf(dp[i][j], dp[i][m] + dp[m + 2][j])
//                        }
//                        dp[i][j] = maxOf(dp[i][j], prices[j] - prices[i])
//                    }
//                }
//            }
//        }

        for (k in 0..n) {
            for (i in 0 until n - k - 1) {
                val j = i + k + 1
//                println("$i $j")
                when {
                    j - i == 1 -> dp[i][j] = prices[j] - prices[i]
                    j - i == 2 -> dp[i][j] = maxOf(maxOf(dp[i][j - 1], dp[i + 1][j]), prices[j] - prices[i])
                    else -> {
                        for (m in i + 1..j - 2) {
                            dp[i][j] = maxOf(dp[i][j], dp[i][m] + dp[m + 2][j])
                        }
                        dp[i][j] = maxOf(dp[i][j], prices[j] - prices[i])
                        dp[i][j] = maxOf(dp[i][j], dp[i + 1][j])
                        dp[i][j] = maxOf(dp[i][j], dp[i][j - 1])
                    }
                }
            }
        }

        dp.forEach {
            it.forEach {
                print("$it, ")
            }
            println()
        }

        return if (dp[0][n - 1] > 0) dp[0][n - 1] else 0
    }
}