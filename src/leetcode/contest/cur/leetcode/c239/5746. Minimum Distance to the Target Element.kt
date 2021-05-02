package leetcode.contest.cur.leetcode.c239

import kotlin.math.abs

class Solution5746 {
    fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
        var min = Int.MAX_VALUE
        for (i in nums.indices) {
            if (nums[i] == target) {
                min = minOf(min, abs(i - start))
            }
        }
        return min
    }
}