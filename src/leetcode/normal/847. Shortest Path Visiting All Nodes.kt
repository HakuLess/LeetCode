package leetcode.normal

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution847()
    s.shortestPathLength("[[1,2,3],[0],[0],[0]]".toGrid()).print()
}

class Solution847 {
    // BFS
    // 状态压缩
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val n = graph.size
        val seen = HashSet<String>()
        fun bfs(): Int {
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            for (i in 0 until n) {
                queue.add(Pair(i, 1 shl i))
            }
            var step = -1
            while (queue.isNotEmpty()) {
                val size = queue.size
                step++
                for (i in 0 until size) {
                    val item = queue.poll()
                    if ("${item.second}:${item.first}" in seen) continue
                    seen.add("${item.second}:${item.first}")
//                    println("add $key:${item.first}")
                    if (item.second + 1 == 1 shl n) return step
                    graph[item.first].forEach {
                        queue.offer(Pair(it, item.second or (1 shl it)))
                    }
                }
            }
            return Int.MAX_VALUE / 2
        }
        return bfs()
    }
}