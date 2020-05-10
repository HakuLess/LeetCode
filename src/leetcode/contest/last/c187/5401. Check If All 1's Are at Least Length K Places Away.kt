package leetcode.contest.last.c187

import leetcode.contest.utils.print

fun main() {
    val s = Solution5401()
    s.kLengthApart(intArrayOf(1, 0, 0, 0, 1, 0, 0, 1), 2).print()
    s.kLengthApart(intArrayOf(1, 0, 0, 1, 0, 1), 2).print()
}

class Solution5401 {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        if (k == 0) {
            return true
        }
        var last = -k - 1
        for (i in nums.indices) {
            if (nums[i] == 1) {
                println("$i, $last, $k")
                if (i - last <= k) {
                    return false
                }
                last = i
            }
        }
        return true
    }
}