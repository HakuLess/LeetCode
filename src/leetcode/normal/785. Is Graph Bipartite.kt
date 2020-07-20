package leetcode.normal

import leetcode.contest.utils.TypedUFS
import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution785()

    s.isBipartite(arrayOf(
            intArrayOf(1, 3),
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(0, 2))).print()

    s.isBipartite(arrayOf(
            intArrayOf(3),
            intArrayOf(2, 4),
            intArrayOf(1),
            intArrayOf(0, 4),
            intArrayOf(1, 3)
    )).print()

    s.isBipartite(arrayOf(
            intArrayOf(1),
            intArrayOf(0, 3),
            intArrayOf(3),
            intArrayOf(1, 2))).print()

    s.isBipartite(arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(0, 2),
            intArrayOf(0, 1, 3),
            intArrayOf(0, 2))).print()
}

class Solution785 {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val n = graph.size
        val ufs = TypedUFS<Int>(n)
        graph.forEach { arr ->
            arr.forEach {
                ufs.union(arr[0], it)
            }
        }
        for (i in 0 until n) {
            if (graph[i].any { ufs.typedFind(it) == ufs.typedFind(i) }) return false
        }
        return true
    }
}