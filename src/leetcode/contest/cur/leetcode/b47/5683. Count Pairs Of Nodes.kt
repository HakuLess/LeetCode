package leetcode.contest.cur.leetcode.b47

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5683()
//    s.countPairs(4, "[[1,2],[2,4],[1,3],[2,3],[2,1]]".toGrid(), intArrayOf(2, 3)).print()
//    s.countPairs(5, "[[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]]".toGrid(), intArrayOf(1, 2, 3, 4, 5)).print()
//    s.countPairs(5, "[[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]]".toGrid(), intArrayOf(5)).print()
//    s.countPairs(5, "[[4,5],[1,3],[1,4]]".toGrid(), intArrayOf(1, 2)).print()
    s.countPairs(7, "[[3,4],[1,2],[5,1],[6,7],[4,1],[5,2],[1,3]]".toGrid(), intArrayOf(2)).print()
//    s.countPairs(6, "[[5,2],[3,5],[4,5],[1,5],[1,4],[3,5],[2,6],[6,4],[5,6],[4,6],[6,2],[2,6],[5,4],[6,1],[6,1],[2,5],[1,3],[1,3],[4,5]]".toGrid(), intArrayOf(18)).print()
}

class Solution5683 {
    fun countPairs(n: Int, edges: Array<IntArray>, queries: IntArray): IntArray {
        val deg = HashMap<Int, Int>()
        val edge = HashMap<Int, Int>()
        edges.forEach {
            it.sort()
            deg[it[0]] = deg.getOrDefault(it[0], 0) + 1
            deg[it[1]] = deg.getOrDefault(it[1], 0) + 1
            val key = it[0] * (n + 1) + it[1]
            edge[key] = edge.getOrDefault(key, 0) + 1
        }

        val ans = IntArray(queries.size)
        val s = ArrayList(deg.values.sorted())
        while (s.size != n)
            s.add(0, 0)

        queries.forEachIndexed { i, it ->
            for (j in 0 until n) {
                var left = j + 1
                var right = n - 1
                while (left <= right) {
                    val mid = (left + right) / 2
                    if (s[j] + s[mid] > it) {
                        right = mid - 1
                    } else {
                        left = mid + 1
                    }
                }
                ans[i] += n - left
            }

            for ((key, value) in edge) {
                val u = key / (n + 1)
                val v = key % (n + 1)
                if (deg[u]!! + deg[v]!! > it && deg[u]!! + deg[v]!! - value <= it) {
                    ans[i]--
                }
            }
        }
        return ans
    }
}