package leetcode.contest.cur.leetcode.c231

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5700()
    s.minChanges(intArrayOf(3, 4, 5, 2, 1, 7, 3, 4, 7), 3).print()
}

class Solution5700 {
    fun minChanges(nums: IntArray, k: Int): Int {
        val group = Array<HashMap<Int, Int>>(k) { hashMapOf() }
        for (i in nums.indices) {
            val value = nums[i]
            group[i % k][value] = group[i % k].getOrDefault(value, 0) + 1
        }
        val max = 1024
        val dp = Array<IntArray>(k) { IntArray(max) }
        for (i in 0 until k) {
            val sum = group[i].values.sum()
            if (i == 0) {
                for (j in 0 until max) {
                    dp[i][j] = sum - group[i].getOrDefault(j, 0)
                }
            } else {
                dp[i].fill(dp[i - 1].min()!! + sum)
                group[i].forEach { (key, value) ->
                    for (pre in 0 until max) {
                        dp[i][pre xor key] = minOf(dp[i][pre xor key], dp[i - 1][pre] + sum - value)
                    }
                }
            }
        }
        return dp[k - 1][0]
    }
}