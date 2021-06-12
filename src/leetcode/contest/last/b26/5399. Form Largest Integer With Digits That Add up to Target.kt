package leetcode.contest.last.b26

import leetcode.contest.utils.print

fun main() {
    val s = Solution5399()
    s.largestNumber(intArrayOf(4, 3, 2, 5, 6, 7, 2, 5, 5), 9).print()
    s.largestNumber(intArrayOf(6, 10, 15, 40, 40, 40, 40, 40, 40), 47).print()
}

class Solution5399 {
    // 动态规划 DP
    fun largestNumber(cost: IntArray, target: Int): String {

        fun getMax(str1: String, str2: String): String {
            return when {
                str1.length > str2.length -> str1
                str1.length == str2.length -> maxOf(str1, str2)
                else -> str2
            }
        }

        val dp = Array<String>(target + 1) { "" }
        for (i in 1..target) {
            for (j in 1..9) {
                if (i - cost[j - 1] in dp.indices && (dp[i - cost[j - 1]].isNotEmpty() || i - cost[j - 1] == 0)) {
                    dp[i] = getMax(dp[i - cost[j - 1]] + j.toString(), dp[i])
                }
            }
        }
        return dp[target].let { if (it.isEmpty()) "0" else it }
    }
}