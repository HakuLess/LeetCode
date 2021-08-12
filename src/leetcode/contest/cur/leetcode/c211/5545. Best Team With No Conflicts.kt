package leetcode.contest.cur.leetcode.c211

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5545()
    s.bestTeamScore(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1), intArrayOf(811, 364, 124, 873, 790, 656, 581, 446, 885, 134)).print()
}

class Solution5545 {
    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        var arr = scores.zip(ages)
        arr = ArrayList(arr.sortedWith(compareBy({ it.second }, { it.first })))
        val dp = IntArray(scores.size) { 0 }
        for (i in dp.indices) {
            dp[i] = arr[i].first
            for (j in 0 until i) {
                if (arr[i].first >= arr[j].first) {
                    dp[i] = maxOf(dp[i], dp[j] + arr[i].first)
                }
            }
        }
        return dp.maxOrNull()!!
    }
}