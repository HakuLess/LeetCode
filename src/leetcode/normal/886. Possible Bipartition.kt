package leetcode.normal

import kotlin.collections.ArrayList


class Solution886 {
    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        val graph = Array(N + 1) { ArrayList<Int>() }
        val visited = IntArray(N + 1)

        fun dfs(curr: Int, color: Int): Boolean {
            if (visited[curr] != 0) {
                return visited[curr] == color
            }
            visited[curr] = color
            for (next in graph[curr]) {
                if (!dfs(next, -color)) return false
            }
            return true
        }

        for (d in dislikes) {
            graph[d[0]].add(d[1])
            graph[d[1]].add(d[0])
        }
        for (i in 1..N) {
            if (visited[i] == 0 && !dfs(i, 1)) return false
        }
        return true
    }
}