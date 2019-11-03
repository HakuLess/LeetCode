package leetcode.contest.cur.c161

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5250()
    s.isGoodArray(intArrayOf(12, 5, 7, 23)).print()
    s.isGoodArray(intArrayOf(29, 6, 10)).print()
    s.isGoodArray(intArrayOf(3, 6)).print()
    s.isGoodArray(intArrayOf(18, 18, 18, 15, 54, 45, 45, 45)).print()
}

class Solution5250 {
    fun isGoodArray(nums: IntArray): Boolean {
        var g = nums[0]
        for (i in nums) g = gcd(i, g)
        return g == 1
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
//    private fun gcd(p1: Int, p2: Int): Int {
//        var n1 = p1
//        var n2 = p2
//        while (n1 != n2) {
//            if (n1 > n2)
//                n1 -= n2
//            else
//                n2 -= n1
//        }
//        return n1
//    }
}