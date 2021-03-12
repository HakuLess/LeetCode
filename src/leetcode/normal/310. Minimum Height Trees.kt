package leetcode.normal

import leetcode.contest.utils.Graph
import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*

fun main(args: Array<String>) {
    val s = Solution310()
    s.findMinHeightTrees(7, "[[0,1],[1,2],[1,3],[2,4],[3,5],[4,6]]".toGrid()).joinToString().print()
}

class Solution310 {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val g = Graph(n)
        edges.forEach {
            g.addEdge(it[0], it[1])
        }
        val queue: Queue<Int> = LinkedList<Int>()
        val degree = IntArray(n) { i -> g.adj[i].size }
        for (i in 0 until n) {
            if (g.adj[i].size == 1) {
                queue.add(i)
            }
        }
        val ans = arrayListOf<Int>(0)
        while (queue.isNotEmpty()) {
            ans.clear()
            ans.addAll(queue)
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                g.adj[item].forEach {
                    degree[it]--
                    if (degree[it] == 1) {
                        queue.offer(it)
                    }
                }
            }
        }
        return ans
    }
}