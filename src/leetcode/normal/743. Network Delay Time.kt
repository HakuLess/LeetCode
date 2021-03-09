package leetcode.normal

import leetcode.contest.utils.Graph
import leetcode.contest.utils.dijkstra
import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution743()
    s.networkDelayTime("[[1,2,1]]".toGrid(), 2, 2).print()
}

class Solution743 {
    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
        val graph = Graph(N)
        times.forEach {
            graph.addEdgeOri(it[0] - 1, it[1] - 1, it[2])
        }
        val ans = graph.dijkstra(K - 1)
        return ans.max()!!.let {
            if (it >= Int.MAX_VALUE / 2) -1
            else it
        }
    }
}