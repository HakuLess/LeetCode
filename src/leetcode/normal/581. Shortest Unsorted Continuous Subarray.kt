package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution581()
    s.findUnsortedSubarray(intArrayOf(2, 6, 4, 8, 10, 9, 15)).print()
}

class Solution581 {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val sorted = nums.sorted()
        var left = -1
        var right = 0
        for (i in nums.indices) {
            if (nums[i] != sorted[i]) {
                left = i
                break
            }
        }
        if (left == -1) return 0
        for (i in nums.indices.reversed()) {
            if (nums[i] != sorted[i]) {
                right = i
                break
            }
        }
        return right - left + 1
    }
}