package leetcode.contest.cur.leetcode.b49

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5708()
    s.countNicePairs(intArrayOf(13, 10, 35, 24, 76)).print()
}

class Solution5708 {
    fun countNicePairs(nums: IntArray): Int {
        val mod = 1000000007L
        val arr = nums.map { it.toString().reversed().toInt() - it }
        arr.joinToString().print()
        val map = hashMapOf<Int, Int>()
        var ans = 0L
        arr.forEach {
            ans += map.getOrDefault(it, 0)
            map[it] = map.getOrDefault(it, 0) + 1
            ans %= mod
        }
        return ans.toInt()
    }
}