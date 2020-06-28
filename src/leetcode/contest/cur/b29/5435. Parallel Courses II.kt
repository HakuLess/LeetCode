package leetcode.contest.cur.b29

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5435()
//    s.minNumberOfSemesters(4, arrayOf(
//            intArrayOf(2, 1),
//            intArrayOf(3, 1),
//            intArrayOf(1, 4)
//    ), 2).print()
//
//    s.minNumberOfSemesters(8, arrayOf(
//            intArrayOf(1, 6),
//            intArrayOf(2, 7),
//            intArrayOf(8, 7),
//            intArrayOf(2, 5),
//            intArrayOf(3, 4)
//    ), 3).print()

//    s.minNumberOfSemesters(5, arrayOf(
//            intArrayOf(3, 1)
//    ), 4).print()

    s.minNumberOfSemesters(9, arrayOf(
            intArrayOf(6, 4),
            intArrayOf(7, 2),
            intArrayOf(1, 3)
    ), 3).print()
}

class Solution5435 {
    fun minNumberOfSemesters(n: Int, dependencies: Array<IntArray>, k: Int): Int {
        // > 2 shl 15
        val dp = IntArray(1 shl n) { n }
        val pre = IntArray(15)
        dependencies.forEach {
            pre[it[1] - 1] = pre[it[1] - 1] or (1 shl it[0] - 1)
        }
        dp[0] = 0

        var i = 0
        while (i < (1 shl n)) {
            var ex = 0
            var j = 0
            while (j < n) {
                if ((i and pre[j]) == pre[j]) ex = ex or (1 shl j)
                j += 1
            }
            ex = ex and i.inv()
            var s = ex
            while (s != 0) {
                if (Integer.bitCount(s) <= k) {
                    dp[i or s] = minOf(dp[i or s], dp[i] + 1)
                }
                s = (s - 1) and ex
            }
            i += 1
        }
        return dp.last()
    }
}