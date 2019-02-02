package leetcode

import kotlin.math.abs

fun minMoves2(nums: IntArray): Int {
    var result = 0
    nums.sort()
    val mid = nums[nums.size / 2]
    nums.forEach {
        result += abs(mid - it)
    }
    return result
}