package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution80()
    s.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)).print()
}

class Solution80 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size < 2) {
            return nums.size
        }
        var pre0 = nums[0]
        var pre1 = nums[1]
        var offset = 0

        for (i in 2 until nums.size) {
            if (nums[i] == pre1 && pre0 == pre1) {
                offset++
            } else {
                pre0 = pre1
                pre1 = nums[i]
                nums[i - offset] = nums[i]
            }
        }
        return nums.size - offset
    }
}