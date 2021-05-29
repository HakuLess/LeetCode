package leetcode.contest.cur.leetcode.b53

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5756()
    s.minimumXORSum(intArrayOf(1, 2), intArrayOf(2, 3)).print()
    s.minimumXORSum(intArrayOf(1, 0, 3), intArrayOf(5, 3, 4)).print()
    s.minimumXORSum(intArrayOf(72, 97, 8, 32, 15), intArrayOf(63, 97, 57, 60, 83)).print()
}

// 二进制 状态压缩
class Solution5756 {
    fun minimumXORSum(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        val dp = Array<IntArray>(n + 1) { IntArray(1 shl n) { Int.MAX_VALUE } }
        dp[0][0] = 0
        for (i in 1..n) {
            for (j in 1..(1 shl n)) {
                for (k in 0 until n) {
                    if (j and (1 shl k) != 0) {
                        // j xor (1 shl k) 回退到nums2未选择k的状态
                        dp[i][j] = minOf(dp[i][j], dp[i - 1][j xor (1 shl k)] + (nums2[k] xor nums1[i - 1]))
                    }
                }
            }
        }
        return dp[n][(1 shl n) - 1]
    }
}