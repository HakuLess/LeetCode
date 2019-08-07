package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution665()
    s.checkPossibility(intArrayOf(3, 4, 2, 3)).print()
    s.checkPossibility(intArrayOf(2, 3, 3, 2, 4)).print()
    s.checkPossibility(intArrayOf(4, 2, 3)).print()
    s.checkPossibility(intArrayOf(-1, 4, 2, 3)).print()
    s.checkPossibility(intArrayOf(1, 3, 4, 2)).print()
}

class Solution665 {
    fun checkPossibility(nums: IntArray): Boolean {
        if (nums.size < 2) {
            return true
        }
        var count = 0
        var skip = 0
        for (i in 1 until nums.size) {
            if (nums[i] < nums[i - 1]) {
                count++
                skip = i
            }
            if (count > 1) {
                return false
            }
        }

        if (count == 0) {
            return true
        }

        // delete skip - 1 or skip
        if (skip == nums.lastIndex || nums[skip + 1] >= nums[skip - 1]) {
            return true
        }

        if (skip == 1 || nums[skip] >= nums[skip - 2]) {
            return true
        }

        return false
    }
}