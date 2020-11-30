package leetcode.contest.cur.leetcode.c216

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5607()
    s.waysToMakeFair(intArrayOf(2, 1, 6, 4)).print()
}

class Solution5607 {
    fun waysToMakeFair(nums: IntArray): Int {
        val n = nums.size
        val total = nums.sum()
        val odd = IntArray(n + 1)
        val even = IntArray(n + 1)
        for (i in 1..n) {
            even[i] += even[i - 1]
            odd[i] += odd[i - 1]
            val num = nums[i - 1]
            if (i % 2 == 1) {
                even[i] += num
            } else {
                odd[i] += num
            }
        }

        var res = 0
        for (i in 0 until n) {
            if (i % 2 == 0) {
                val cur = odd[i + 1] + even[n] - even[i + 1]
                if (cur == total - cur - nums[i]) {
                    res++
                }
            } else {
                val cur = even[i + 1] + odd[n] - odd[i + 1]
                if (cur == total - cur - nums[i]) {
                    res++
                }
            }
        }
        return res
    }
}