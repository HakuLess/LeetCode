package leetcode.contest.last.c154

import java.util.LinkedList
import java.util.ArrayList

class Solution5192 {

    var res = ArrayList<List<Int>>()
    private var adj: Array<LinkedList<Int>>? = null
    var time = 0

    private fun bridgeUtil(u: Int, visited: BooleanArray, disc: IntArray, low: IntArray, parent: IntArray) {
        visited[u] = true
        low[u] = ++time
        disc[u] = low[u]

        adj!![u].forEach { v ->
            if (!visited[v]) {
                parent[v] = u
                bridgeUtil(v, visited, disc, low, parent)

                low[u] = minOf(low[u], low[v])

                if (low[v] > disc[u]) {
                    val list = LinkedList<Int>()
                    list.add(u)
                    list.add(v)
                    res.add(list)
                }
            } else if (v != parent[u])
                low[u] = minOf(low[u], disc[v])
        }
    }

    fun criticalConnections(V: Int, connections: List<List<Int>>): List<List<Int>> {
        val size = connections.size

        adj = Array(V) { LinkedList<Int>() }
        for (i in 0 until size) {
            adj!![connections[i][0]].add(connections[i][1])
            adj!![connections[i][1]].add(connections[i][0])
        }

        val visited = BooleanArray(V)
        val disc = IntArray(V)
        val low = IntArray(V)
        val parent = IntArray(V)

        for (i in 0 until V) {
            parent[i] = -1
            visited[i] = false
        }
        for (i in 0 until V) {
            if (!visited[i])
                bridgeUtil(i, visited, disc, low, parent)
        }
        return res
    }
}
