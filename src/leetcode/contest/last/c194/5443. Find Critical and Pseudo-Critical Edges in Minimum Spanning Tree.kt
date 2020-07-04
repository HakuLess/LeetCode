package leetcode.contest.last.c194

import leetcode.contest.utils.UFS
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5443()
//    s.findCriticalAndPseudoCriticalEdges(6, arrayOf(
//            intArrayOf(0, 1, 2),
//            intArrayOf(0, 2, 5),
//            intArrayOf(2, 3, 5),
//            intArrayOf(1, 4, 4),
//            intArrayOf(2, 5, 5),
//            intArrayOf(4, 5, 2)
//    )).forEach {
//        it.joinToString(", ").print()
//    }

    s.findCriticalAndPseudoCriticalEdges(6, arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(0, 2, 1),
            intArrayOf(2, 3, 4),
            intArrayOf(3, 4, 2),
            intArrayOf(3, 5, 2),
            intArrayOf(4, 5, 2)
    )).forEach {
        it.joinToString(", ").print()
    }
}

class Solution5443 {
    fun findCriticalAndPseudoCriticalEdges(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val e = edges.sortedBy { it[2] }
        val ufs = UFS(n)
        var ans = 0
        for (i in e.indices) {
            if (ufs.union(e[i][0], e[i][1])) {
                ans += e[i][2]
            }
        }

        fun checkEdge(forbidden: Int, must: Int): Int {
            val ufs = UFS(n)
            var cur = 0
            var cnt = 0
            if (must != -1) {
                cur = edges[must][2]
                ufs.union(edges[must][0], edges[must][1])
                cnt++
            }
            for (i in e.indices) {
                if (e[i] == edges.getOrNull(must) || e[i] == edges.getOrNull(forbidden)) continue
                val it = e[i]
                if (ufs.union(it[0], it[1])) {
                    cur += it[2]
                    cnt++
                }
            }
            if (forbidden != -1)
                println("$forbidden, $ans, $cnt")
            return if (cnt < n - 1) Int.MAX_VALUE else cur
        }

        val res0 = arrayListOf<Int>()
        val res1 = arrayListOf<Int>()

        for (i in edges.indices) {
            if (checkEdge(i, -1) != ans) {
                res0.add(i)
            } else if (checkEdge(-1, i) == ans) {
                res1.add(i)
            }
        }

        return listOf(res0, res1)
    }
}