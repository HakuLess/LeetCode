package leetcode.contest.last.b30

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5446()
//    s.minDifference(intArrayOf(5, 3, 2, 4)).print()
    s.minDifference(intArrayOf(5, 6, 7, 8, 9)).print()
}

class Solution5446 {
    fun minDifference(nums: IntArray): Int {
        if (nums.size <= 4) return 0
        nums.sort()
        val n = nums.size
        var ans = Int.MAX_VALUE
        for (i in 0 until 4) {
            ans = minOf(ans, nums[n - 4 + i] - nums[i])
        }
        return ans
    }
}