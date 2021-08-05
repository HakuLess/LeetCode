package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution802()
    // [[1,2],[2,3],[5],[0],[5],[],[]]
    s.eventualSafeNodes(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(5),
            intArrayOf(0),
            intArrayOf(5),
            intArrayOf(),
            intArrayOf(),
        )
    ).joinToString().print()
}

class Solution802 {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val color = IntArray(n) { 0 }
        fun dfs(i: Int): Boolean {
            if (color[i] > 0)
                return color[i] == 2
            color[i] = 1
            for (j in graph[i])
                if (!dfs(j)) return false
            color[i] = 2
            return true
        }
        return (0 until n).filter { dfs(it) }
    }
}