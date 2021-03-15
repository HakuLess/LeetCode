package leetcode.contest.last.c226

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5667()
    s.canEat(intArrayOf(7, 4, 5, 3, 8), "[[1,1,1]]".toGrid()).print()
}

class Solution5667 {
    fun canEat(candiesCount: IntArray, queries: Array<IntArray>): BooleanArray {
        val n = candiesCount.size
        val preSum = LongArray(n + 1)
        for (i in candiesCount.indices) {
            preSum[i + 1] = preSum[i] + candiesCount[i]
        }
        val ans = ArrayList<Boolean>()
        for (q in queries) {
            val min = preSum[q[0]] + 1
            val max = preSum[q[0] + 1]
            val day = q[1]
            val cap = q[2].toLong()
            val dayMin = day + 1
            val dayMax = (day + 1) * cap
            ans.add(min <= dayMax && max >= dayMin)
        }
        return ans.toBooleanArray()
    }
}