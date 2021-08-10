package leetcode.contest.last.b58

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5828()
    s.minSpaceWastedKResizing(intArrayOf(10, 20), 0).print()
    s.minSpaceWastedKResizing(intArrayOf(10, 20, 30), 1).print()
//    s.minSpaceWastedKResizing(intArrayOf(10, 20, 15, 30, 20), 2).print()
//    s.minSpaceWastedKResizing(intArrayOf(2, 48, 18, 16, 15, 9, 48, 7, 44, 48), 1).print()
//    s.minSpaceWastedKResizing(intArrayOf(13, 46, 42, 45, 35), 4).print()
}

class Solution5828 {
    // DP
    // 每段范围内值，求调整K次后的最小值
    fun minSpaceWastedKResizing(nums: IntArray, k: Int): Int {
        val n = nums.size
        // 获取[i..j]范围内 最大值*count 减去 sum 的二维数组
        val cost = Array<IntArray>(nums.size) { IntArray(nums.size) }
        for (i in nums.indices) {
            var cur = nums[i]
            var sum = nums[i]
            for (j in i + 1 until nums.size) {
                cur = maxOf(cur, nums[j])
                sum += nums[j]
                cost[i][j] = cur * (j - i + 1) - sum
            }
        }
        val dp = Array<IntArray>(n) { IntArray(k + 2) { Int.MAX_VALUE / 2 } }
        for (j in 1..k + 1) {
            for (i in 0 until n) {
                // 第l位开始转移的最小值
                for (l in 0..i) {
                    // 第j次转移，前i个值的浪费最小值
                    dp[i][j] = minOf(dp[i][j], (if (l == 0) 0 else dp[l - 1][j - 1]) + cost[l][i])
                }
            }
        }
        return dp[n - 1][k + 1]
    }
}