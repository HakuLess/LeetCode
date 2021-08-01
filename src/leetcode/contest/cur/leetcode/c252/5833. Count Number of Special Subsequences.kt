package leetcode.contest.cur.leetcode.c252

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5833()
    s.countSpecialSubsequences(intArrayOf(0, 1, 2, 2)).print()
    s.countSpecialSubsequences(intArrayOf(2, 2, 0, 0)).print()
    s.countSpecialSubsequences(intArrayOf(0, 1, 2, 0, 1, 2)).print()
}

class Solution5833 {
    fun countSpecialSubsequences(nums: IntArray): Int {
        val mod = 1000000007L
        var a = 0L
        var b = 0L
        var c = 0L
        for (x in nums) {
            when (x) {
                0 -> a = (a * 2 + 1) % mod
                1 -> b = (b * 2 + a) % mod
                2 -> c = (c * 2 + b) % mod
            }
        }
        return c.toInt()
    }
}