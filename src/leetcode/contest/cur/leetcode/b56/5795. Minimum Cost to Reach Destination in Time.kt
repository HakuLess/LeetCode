package leetcode.contest.cur.leetcode.b56

import leetcode.contest.utils.Graph
import java.util.*

class Solution5795 {

    // BFS以Time作为优先级队列的Key
    fun minCost(maxTime: Int, edges: Array<IntArray>, passingFees: IntArray): Int {
        edges.sortByDescending { it[2] }
        val n = passingFees.size
        val g = Graph(n)
        edges.forEach {
            g.addEdge(it[0], it[1], it[2])
        }
        var ans = Int.MAX_VALUE / 2
        // pos, time, fee
        val queue: PriorityQueue<Triple<Int, Int, Int>> = PriorityQueue(compareBy { it.second })
        val minFee = IntArray(n) { Int.MAX_VALUE }
        minFee[0] = passingFees[0]
        queue.add(Triple(0, 0, passingFees[0]))
        while (queue.isNotEmpty()) {
            // 不需要按层遍历，以时间维度排序
            val (pos, time, fee) = queue.poll()
            if (time > maxTime) continue
            if (minFee[pos] < fee) continue
            if (pos == n - 1) {
                ans = minOf(ans, fee)
                continue
            }
            g.adj[pos].forEach {
                if (minFee[it] > fee + passingFees[it]) {
                    queue.offer(Triple(it, time + g.weight[pos]!![it]!!, fee + passingFees[it]))
                    minFee[pos] = fee
                }
            }
        }
        return if (ans != Int.MAX_VALUE / 2) ans else -1
    }

    // DP
    // 最短路径 二重条件 时间限制与边的权重
//    fun minCost(maxTime: Int, edges: Array<IntArray>, passingFees: IntArray): Int {
//        edges.sortByDescending { it[2] }
//        val n = passingFees.size
//        val g = Graph(n)
//        edges.forEach {
//            g.addEdge(it[0], it[1], it[2])
//        }
//        var ans = Int.MAX_VALUE / 2
//        // 时间维度
//        val dp = Array<IntArray>(maxTime + 1) { IntArray(n) { Int.MAX_VALUE / 2 } }
//        dp[0][0] = passingFees[0]
//        for (i in 1..maxTime) {
//            // 边的总数 进行遍历
//            for (u in 0 until n) {
//                g.adj[u].forEach {
//                    val w = g.weight[it]!![u]!!
//                    if (i >= w) {
//                        dp[i][u] = minOf(dp[i][u], dp[i - w][it] + passingFees[u])
//                    }
//                }
//            }
//            ans = minOf(ans, dp[i][n - 1])
//        }
//        return if (ans != Int.MAX_VALUE / 2) ans else -1
//    }
}