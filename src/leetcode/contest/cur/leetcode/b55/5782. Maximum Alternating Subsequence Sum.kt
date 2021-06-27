package leetcode.contest.cur.leetcode.b55

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5782()
    s.maxAlternatingSum(intArrayOf(4)).print()
//    s.maxAlternatingSum(intArrayOf(4, 2, 5, 3)).print()
//    s.maxAlternatingSum(intArrayOf(5, 6, 7, 8)).print()
//    s.maxAlternatingSum(intArrayOf(6, 2, 1, 2, 4, 5)).print()
}

class Solution5782 {
    fun maxAlternatingSum(nums: IntArray): Long {
        var cur = Pair(Long.MIN_VALUE / 2, 0L)
        for (num in nums) {
            // 当前数字为偶数位的最大值，当前数字为奇数位的最大值
            cur = Pair(maxOf(cur.first, cur.second + num), maxOf(cur.second, cur.first - num))
        }
        return cur.first
    }
}