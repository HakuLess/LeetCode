package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution376()
    s.wiggleMaxLength(intArrayOf(1, 7, 4, 9, 2, 5)).print()
    s.wiggleMaxLength(intArrayOf(1, 17, 5, 10, 13, 15, 10, 5, 16, 8)).print()
    s.wiggleMaxLength(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)).print()
}

class Solution376 {
    fun wiggleMaxLength(nums: IntArray): Int {
        if (nums.size < 2) return nums.size
        var up = 1
        var down = 1
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1
            }
        }
        return maxOf(up, down)
    }
}