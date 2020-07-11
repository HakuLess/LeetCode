package leetcode.contest.cur.leetcode.b30

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5446()
//    s.minDifference(intArrayOf(5, 3, 2, 4)).print()
    s.minDifference(intArrayOf(5, 6, 7, 8, 9)).print()
}

class Solution5446 {
    fun minDifference(nums: IntArray): Int {
        if (nums.size <= 4) {
            return 0
        }
        var min0 = Int.MAX_VALUE
        var min1 = Int.MAX_VALUE
        var min2 = Int.MAX_VALUE
        var min3 = Int.MAX_VALUE
        var max0 = Int.MIN_VALUE
        var max1 = Int.MIN_VALUE
        var max2 = Int.MIN_VALUE
        var max3 = Int.MIN_VALUE
        nums.forEach {
            if (it < min0) {
                min3 = min2
                min2 = min1
                min1 = min0
                min0 = it
            } else if (it < min1) {
                min3 = min2
                min2 = min1
                min1 = it
            } else if (it < min2) {
                min3 = min2
                min2 = it
            } else if (it < min3) {
                min3 = it
            }

            if (it > max0) {
                max3 = max2
                max2 = max1
                max1 = max0
                max0 = it
            } else if (it > max1) {
                max3 = max2
                max2 = max1
                max1 = it
            } else if (it > max2) {
                max3 = max2
                max2 = it
            } else if (it > max3) {
                max3 = it
            }
        }
        var ans = Int.MAX_VALUE
        ans = minOf(ans, max3 - min0)
        ans = minOf(ans, max2 - min1)
        ans = minOf(ans, max1 - min2)
        ans = minOf(ans, max0 - min3)
        return ans
    }
}