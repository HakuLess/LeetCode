package leetcode.contest.last.c173

import leetcode.contest.utils.Graph
import leetcode.contest.utils.dijkstra
import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5321()
    s.findTheCity(4, "[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]".toGrid(), 4).print()
}

class Solution5321 {
    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        val graph = Graph(n)
        edges.forEach {
            graph.addEdge(it[0], it[1], it[2])
        }
        var cur = Int.MAX_VALUE
        var ans = -1
        for (i in 0 until n) {
            val c = graph.dijkstra(i).count { it <= distanceThreshold }
            if (cur >= c) {
                cur = c
                ans = i
            }
        }
        return ans
    }
}