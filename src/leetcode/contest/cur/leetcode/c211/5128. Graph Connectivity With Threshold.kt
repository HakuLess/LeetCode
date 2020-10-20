package leetcode.contest.cur.leetcode.c211

import leetcode.contest.utils.TypedUFS
import leetcode.contest.utils.getPrime
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5128()
//    s.areConnected(10000, 0, arrayOf(intArrayOf(4, 10)))
//    s.areConnected(656, 145, arrayOf(intArrayOf(411, 494))).joinToString().print()
    s.areConnected(6, 2, arrayOf(intArrayOf(3, 6))).joinToString().print()
}

class Solution5128 {
    fun areConnected(n: Int, threshold: Int, queries: Array<IntArray>): List<Boolean> {
        if (threshold == 0) return List(queries.size) { true }
        val ufs = TypedUFS<Int>(n)
        for (i in threshold + 1..n) {
            var j = 2
            while (i * j <= n) {
                ufs.union(i, i * j)
                j++
            }
        }
        val ans = ArrayList<Boolean>()
        queries.forEach {
            ans.add(ufs.typedFind(it[0]) == ufs.typedFind(it[1]))
        }
        return ans
    }
}

