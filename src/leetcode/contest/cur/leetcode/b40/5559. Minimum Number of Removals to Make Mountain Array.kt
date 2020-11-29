package leetcode.contest.cur.leetcode.b40

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5559()
    s.minimumMountainRemovals(intArrayOf(1, 3, 1)).print()
    s.minimumMountainRemovals(intArrayOf(10, 9, 8, 3, 1, 7, 6, 5, 4, 3, 2, 1)).print()
}

class Solution5559 {
    fun minimumMountainRemovals(nums: IntArray): Int {
        val dp0 = IntArray(nums.size)
        val dp1 = IntArray(nums.size)
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[j] > nums[i]) {
                    dp0[j] = maxOf(dp0[j], dp0[i] + 1)
                }
            }
        }
        for (i in nums.indices.reversed()) {
            for (j in i - 1 downTo 0) {
                if (nums[j] > nums[i]) {
                    dp1[j] = maxOf(dp1[j], dp1[i] + 1)
                }
            }
        }
        var ans = 0
        dp0.print()
        dp1.print()
        for (i in nums.indices) {
            if (dp0[i] != 0 && dp1[i] != 0)
                ans = maxOf(ans, dp0[i] + dp1[i])
        }
        return nums.size - ans - 1
    }
}