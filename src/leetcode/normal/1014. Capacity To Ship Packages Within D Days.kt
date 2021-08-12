package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1014()
    s.shipWithinDays(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5).print()
    s.shipWithinDays(intArrayOf(3, 2, 2, 4, 1, 4), 3).print()
    s.shipWithinDays(intArrayOf(1, 2, 3, 1, 1), 4).print()
}

class Solution1014 {
    fun shipWithinDays(weights: IntArray, D: Int): Int {
        fun calDays(cap: Int): Int {
            var ans = 1
            var cur = 0
            for (weight in weights) {
                if (cur + weight <= cap) {
                    cur += weight
                } else {
                    cur = weight
                    ans++
                }
            }
            return ans
        }

        var left = weights.maxOrNull()!!
        var right = weights.sum()
        while (left < right) {
            val mid = left + (right - left) / 2
            val cal = calDays(mid)
            if (cal <= D) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
}