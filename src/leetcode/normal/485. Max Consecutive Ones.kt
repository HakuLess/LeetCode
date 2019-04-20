package leetcode.normal

import kotlin.math.max

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var ans = 0
    for (i in 0 until nums.size) {
        if (nums[i] == 0) {
            continue
        }
        if (nums[i] == 1) {
            nums[i] = 1 + nums.getOrElse(i - 1) { 0 }
            ans = max(ans, nums[i])
        }
    }
    return ans
}