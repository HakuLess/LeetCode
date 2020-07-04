package leetcode.contest.last.b29

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5434()
    s.longestSubarray(intArrayOf(1, 0, 0, 0, 0)).print()
//    s.longestSubarray(intArrayOf(1, 1, 0, 1)).print()
//    s.longestSubarray(intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)).print()
//    s.longestSubarray(intArrayOf(1, 1, 0, 0, 1, 1, 1, 0, 1)).print()
}

class Solution5434 {
    fun longestSubarray(nums: IntArray): Int {
        val dp = arrayListOf<Int>()
        for (i in nums.indices) {
            if (nums[i] != 1) {
                dp.add(i)
            }
        }
        if (dp.isEmpty()) return nums.count { it == 1 } - 1
        if (dp.size == 1) return nums.count { it == 1 }

        dp.add(0, -1)
        dp.add(nums.size)
//        dp.toIntArray().print()
        var ans = 0
        for (i in dp.indices) {
            if (i >= 2) {
                ans = maxOf(dp[i] - dp[i - 2], ans)
            }
        }
        return ans - 2
    }
}