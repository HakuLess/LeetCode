package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution688()
    s.knightProbability(3, 2, 0, 0).print()
//    s.knightProbability(8, 30, 6, 4).print()
}

class Solution688 {

    fun knightProbability(N: Int, K: Int, r: Int, c: Int): Double {
        val dp = Array(N) { Array(N) { DoubleArray(K + 1) { 1.0 } } }
        var ans = 0.0
        for (k in 1..K) {
            for (i in 0 until N) {
                for (j in 0 until N) {
                    dp[i][j][k] = getAns(N, k, i, j, dp)
                }
            }
        }

        dp.forEach {
            it.forEach {
                it.forEach {
                    print("$it, ")
                }
                print(": ")
            }
            println()
        }

        return dp[r][c][K]
    }

    private fun getAns(N: Int, K: Int, r: Int, c: Int, dp: Array<Array<DoubleArray>>): Double {

        var ans = 0.0
        ans += getRCK(N, K - 1, r - 2, c - 1, dp)
        ans += getRCK(N, K - 1, r + 2, c - 1, dp)
        ans += getRCK(N, K - 1, r - 2, c + 1, dp)
        ans += getRCK(N, K - 1, r + 2, c + 1, dp)
        ans += getRCK(N, K - 1, r - 1, c - 2, dp)
        ans += getRCK(N, K - 1, r + 1, c - 2, dp)
        ans += getRCK(N, K - 1, r - 1, c + 2, dp)
        ans += getRCK(N, K - 1, r + 1, c + 2, dp)

        return ans / 8.0
    }

    private fun getRCK(N: Int, K: Int, r: Int, c: Int, dp: Array<Array<DoubleArray>>): Double {
        if (r < 0 || r >= N) {
            return 0.0
        }
        if (c < 0 || c >= N) {
            return 0.0
        }
        return dp[r][c][K]
    }
}