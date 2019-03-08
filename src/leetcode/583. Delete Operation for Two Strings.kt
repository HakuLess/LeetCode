package leetcode

fun main(args: Array<String>) {
    val s = Solution583()
    s.minDistance("eat", "sea").print()
}

class Solution583 {
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }

        for (i in 1 until word1.length + 1) {
            dp[i][0] = dp[i - 1][0] + 1
        }
        for (i in 1 until word2.length + 1) {
            dp[0][i] = dp[0][i - 1] + 1
        }

        for (i in 1 until word1.length + 1) {
            val c1 = word1[i - 1]
            for (j in 1 until word2.length + 1) {
                val c2 = word2[j - 1]
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    val b = dp[i - 1][j] + 1
                    val c = dp[i][j - 1] + 1
                    dp[i][j] = minOf(b, c)
                }
            }
        }

        dp.forEach {
            it.forEach {
                print("$it, ")
            }
            println()
        }

        return dp.last().last()
    }
}