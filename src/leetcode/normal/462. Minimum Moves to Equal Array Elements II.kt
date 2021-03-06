package leetcode.normal

import kotlin.math.abs

class Solution462 {
    fun minMoves2(nums: IntArray): Int {
        var result = 0
        nums.sort()
        val mid = nums[nums.size / 2]
        nums.forEach {
            result += abs(mid - it)
        }
        return result
    }
}