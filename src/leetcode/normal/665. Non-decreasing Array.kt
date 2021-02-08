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
        val n = nums.size
        var cnt = 0
        for (i in 0 until n - 1) {
            val x = nums[i]
            val y = nums[i + 1]
            if (x > y) {
                cnt++
                if (cnt > 1) {
                    return false
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x
                }
            }
        }
        return true
    }
}
