package leetcode.contest.cur.leetcode.c201

import leetcode.contest.utils.print

fun main() {
    val s = Solution5471()
//    s.maxNonOverlapping(intArrayOf(1, 1, 1, 1, 1), 2).print()
//    s.maxNonOverlapping(intArrayOf(-1, 3, 5, 1, 4, 2, -9), 6).print()

//    s.maxNonOverlapping(intArrayOf(-1, -2, 8, -3, 8, -5, 5, -4, 5, 4, 1), 5).print()
    s.maxNonOverlapping(intArrayOf(3, 0, 2, 0, 2, 3, 3, 0, 0, 2, 1, 1, 1, 0, -1, -1, 1, -1, 1, 0, 2, 0, 0, 3, 0, 0, 3, 1, 0, 2, 0, -1, 2, -1, 1, 1, 3, 0, 2, 3, 3, 0, 0, 2, -1, 1), 3).print()
}

class Solution5471 {
    fun maxNonOverlapping(nums: IntArray, target: Int): Int {
        var ans = 0
        var sum = 0
        var pre = hashSetOf<Int>(0)
        for (i in nums.indices) {
            sum += nums[i]
            if (pre.contains(sum - target)) {
                ans++
                sum = 0
                pre = hashSetOf<Int>(0)
            } else {
                pre.add(sum)
            }
        }
        return ans
    }
}