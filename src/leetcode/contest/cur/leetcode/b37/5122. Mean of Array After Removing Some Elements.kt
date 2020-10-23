package leetcode.contest.cur.leetcode.b37

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5122()
    s.trimMean(intArrayOf(1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3)).print()
}

class Solution5122 {
    fun trimMean(arr: IntArray): Double {
        arr.sort()
        val n = arr.size
        val sub = arr.size / 20
        return (arr.sum() - arr.take(sub).sum() - arr.takeLast(sub).sum()).toDouble() / (n - 2 * sub)
    }
}