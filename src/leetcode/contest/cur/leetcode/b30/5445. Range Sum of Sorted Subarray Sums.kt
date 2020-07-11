package leetcode.contest.cur.leetcode.b30

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5445()
    s.rangeSum(intArrayOf(1, 2, 3, 4), 4, 1, 5).print()
}

class Solution5445 {
    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val mod = 1000000007L
        val sum = arrayListOf<Long>()
        for (i in nums.indices) {
            sum.add(nums[i].toLong())
//            println("add i ${nums[i]}")
            var cur = nums[i]
            for (j in i + 1..nums.lastIndex) {
                cur += nums[j]
                sum.add(cur.toLong())
//                println("add cur $cur")
            }
        }
        sum.sort()
//        sum.joinToString(" ").print()
        var ans = 0L
        for (i in left - 1 until right) {
            ans = (ans + sum[i]) % mod
        }
        return ans.toInt()
    }
}