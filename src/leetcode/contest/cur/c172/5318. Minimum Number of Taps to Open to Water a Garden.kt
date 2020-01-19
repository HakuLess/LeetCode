package leetcode.contest.cur.c172

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5318()
//    s.minTaps(5, intArrayOf(3, 4, 1, 1, 0, 0)).print()
//    s.minTaps(7, intArrayOf(1, 2, 1, 0, 2, 1, 0, 1)).print()
    s.minTaps(17, intArrayOf(0, 3, 3, 2, 2, 4, 2, 1, 5, 1, 0, 1, 2, 3, 0, 3, 1, 1)).print()
//    s.minTaps(3, intArrayOf(0, 0, 0, 0)).print()
}

class Solution5318 {
    fun minTaps(n: Int, ranges: IntArray): Int {
        var p = 0
        var q = 0
        var res = 0
        while (p < n) {
            for (i in p..n) {
                if (i - ranges[i] <= p) {
                    q = maxOf(q, i + ranges[i])
                }
            }
            if (p == q) return -1
            p = q
            res++
        }
        return res
    }
}