package leetcode.contest.last.c231

import kotlin.math.abs

class Solution5698 {
    fun minElements(nums: IntArray, limit: Int, goal: Int): Int {
        var sum: Long = 0
        val g = goal.toLong()
        nums.forEach {
            sum += it
        }
        return ((abs(sum - g) + limit - 1) / limit).toInt()
    }
}