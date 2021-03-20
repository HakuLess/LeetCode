package leetcode.contest.cur.leetcode.b48

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5712()
    s.getMaximumConsecutive(intArrayOf(1, 3)).print()
}

class Solution5712 {
    fun getMaximumConsecutive(coins: IntArray): Int {
        coins.sort()
        var cur = 0
        for (i in coins.indices) {
            if (cur >= coins[i] - 1)
                cur += coins[i]
            else {
                return cur + 1
            }
        }
        return cur + 1
    }
}