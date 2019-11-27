package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution55()
    s.canJump(intArrayOf(2, 3, 1, 1, 4)).print()
}

class Solution55 {
    fun canJump(nums: IntArray): Boolean {
        val n = nums.size
        var jumpIndex = n - 1
        for (i in n - 2 downTo 0) {
            if (i + nums[i] >= jumpIndex) {
                jumpIndex = i
            }
        }
        return jumpIndex == 0
    }
//    fun canJump(nums: IntArray): Boolean {
//        if (nums.isEmpty()) {
//            return false
//        }
//        val ans = BooleanArray(nums.size) { false }
//        ans[0] = true
//        for (i in nums.indices) {
//            for (j in 1..nums[i]) {
//                if (ans[i] && i + j < ans.size) {
//                    ans[i + j] = true
//                }
//            }
//        }
//        return ans.last()
//    }
}