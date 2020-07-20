package leetcode.contest.cur.leetcode.c198

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5464()
    s.numWaterBottles(15, 8).print()
}

class Solution5464 {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var cur = numBottles
        var ans = 0
        var left = 0
        while (cur != 0) {
            ans += cur
            cur += left
            left = cur % numExchange
            cur /= numExchange
        }
        return ans
    }
}