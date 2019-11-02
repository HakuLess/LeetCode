package leetcode.contest.cur.b12

import leetcode.contest.utils.print
import java.util.LinkedList

fun main(args: Array<String>) {
    val s = Solution5098()
    s.treeDiameter(arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2)
    )).print()

    s.treeDiameter(arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(1, 4),
            intArrayOf(4, 5)
    )).print()
}

class Solution5098 {

    var diameter = IntArray(10001)

    fun treeDiameter(edges: Array<IntArray>): Int {
        var n = 0
        edges.forEach {
            it[0] = it[0] + 1
            it[1] = it[1] + 1
            n = maxOf(it[0], it[1])
        }

        val cur = HashMap<Int, ArrayList<Int>>()
        edges.forEach {
            if (cur[it[0]] == null) {
                cur[it[0]] = ArrayList()
            }
            cur[it[0]]!!.add(it[1])
            if (cur[it[1]] == null) {
                cur[it[1]] = ArrayList()
            }
            cur[it[1]]!!.add(it[0])
        }

        val init = bfs(1, cur, n)
        val `val` = bfs(init, cur, n)
        return diameter[`val`]
    }

    private fun bfs(init: Int, arr: HashMap<Int, ArrayList<Int>>, n: Int): Int {
        // Initializing queue
        val q = LinkedList<Int>()
        q.add(init)

        val visited = IntArray(n + 1)
        for (i in 0..n) {
            visited[i] = 0
            diameter[i] = 0
        }

        // Pushing each node in queue
        q.add(init)

        // Mark the traversed node visited
        visited[init] = 1
        while (q.size > 0) {
            val u = q.peek()
            q.remove()
            for (i in arr[u]!!.indices) {
                if (visited[arr[u]!![i]] == 0) {
                    visited[arr[u]!![i]] = 1

                    // Considering weight of edges equal to 1
                    diameter[arr[u]!![i]] += diameter[u] + 1
                    q.add(arr[u]!![i])
                }
            }
        }
        var `in` = 0
        for (i in 0..n) {
            if (diameter[i] > diameter[`in`])
                `in` = i
        }

        // return index of max value in diameter
        return `in`
    }
}