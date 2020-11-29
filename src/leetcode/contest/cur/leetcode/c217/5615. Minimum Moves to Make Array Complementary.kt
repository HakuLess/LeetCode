package leetcode.contest.cur.leetcode.c217

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = Solution5615()
//    s.minMoves(intArrayOf(1, 2, 4, 3), 4).print()
//    s.minMoves(intArrayOf(1, 2, 2, 1), 2).print()
//    s.minMoves(intArrayOf(1, 2, 1, 2), 2).print()
    s.minMoves(intArrayOf(1, 3, 1, 1, 1, 2, 3, 2, 3, 1, 3, 2, 1, 3), 3).print()
}

class Solution5615 {
    fun minMoves(nums: IntArray, limit: Int): Int {
        val n = nums.size
        val s = IntArray(limit * 2 + 2)
        for (i in 0 until nums.size / 2) {
            val l = 1 + minOf(nums[i], nums[n - i - 1])
            val h = limit + maxOf(nums[i], nums[n - i - 1])
            val sum = nums[i] + nums[n - i - 1]
            s[l]--
            s[sum]--
            s[sum + 1]++
            s[h + 1]++
        }
        s.print()
        var now = n
        var ans = n
        for (i in 2..limit * 2) {
            now += s[i]
            ans = minOf(ans, now)
        }
        return ans
    }
}