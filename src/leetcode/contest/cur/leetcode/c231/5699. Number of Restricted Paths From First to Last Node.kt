package leetcode.contest.cur.leetcode.c231

import leetcode.contest.utils.Graph
import leetcode.contest.utils.dijkstra
import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import kotlin.collections.HashMap


fun main(args: Array<String>) {
    val s = Solution5699()
    s.countRestrictedPaths(5, "[[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]".toGrid()).print()
//    s.countRestrictedPaths(10, "[[9,10,8],[9,6,5],[1,5,9],[6,8,10],[1,8,1],[8,10,7],[10,7,9],[5,7,3],[4,2,9],[2,3,9],[3,10,4],[1,4,7],[7,6,1],[3,9,8],[9,1,6],[4,7,10],[9,4,9]]".toGrid()).print()
}

class Solution5699 {
    fun countRestrictedPaths(n: Int, edges: Array<IntArray>): Int {
        val mod = 1000000007L
        val graph = Graph(n + 1)
        edges.forEach {
            graph.addEdge(it[0], it[1], it[2])
        }

        val dis = graph.dijkstra(n)

        val seen = HashMap<Int, Long>()
        fun dfs(node: Int): Long {
            if (node in seen) return seen[node]!!
            if (node == 0) return 0L
            if (node == n) return 1L
            var ans = 0L
            graph.adj[node].forEach {
                if (dis[it] < dis[node]) {
                    ans += dfs(it)
                    ans %= mod
                }
            }
            return ans.also {
                seen[node] = it
            }
        }
        return (dfs(1) % mod).toInt()
    }
}