package leetcode.contest.cur.leetcode.b37

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5122()
    s.trimMean(intArrayOf(1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3)).print()
}

class Solution5122 {
    fun trimMean(arr: IntArray): Double {
        arr.sort()
        val sub = arr.size / 20
        var sum = arr.sum()
        for (i in arr.indices) {
            if (i < sub) {
                sum -= arr[i]
            } else if (i >= arr.size - sub) {
                sum -= arr[i]
            }
        }
        return sum.toDouble() / (arr.size - sub * 2)
    }
}