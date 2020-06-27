package leetcode.contest.cur.b29

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5435()
//    s.minNumberOfSemesters(4, arrayOf(
//            intArrayOf(2, 1),
//            intArrayOf(3, 1),
//            intArrayOf(1, 4)
//    ), 2).print()
//
//    s.minNumberOfSemesters(8, arrayOf(
//            intArrayOf(1, 6),
//            intArrayOf(2, 7),
//            intArrayOf(8, 7),
//            intArrayOf(2, 5),
//            intArrayOf(3, 4)
//    ), 3).print()

//    s.minNumberOfSemesters(5, arrayOf(
//            intArrayOf(3, 1)
//    ), 4).print()

    s.minNumberOfSemesters(9, arrayOf(
            intArrayOf(6, 4),
            intArrayOf(7, 2),
            intArrayOf(1, 3)
    ), 3).print()
}

class Solution5435 {
    fun minNumberOfSemesters(n: Int, dependencies: Array<IntArray>, k: Int): Int {
        val g = Graph(n)
        dependencies.forEach {
            g.addEdgeOri(it[0] - 1, it[1] - 1)
        }
        return g.topologicalSort(k)
    }
}

class Graph(val V: Int) {

    // Array  of lists for Adjacency List Representation
    var adj: Array<LinkedList<Int>> = Array(V) { LinkedList<Int>() }

    fun addEdgeOri(v: Int, w: Int) {
        adj[v].add(w)
    }

    // prints a Topological Sort of the complete graph
    fun topologicalSort(k: Int): Int {
        // Create a array to store indegrees of all
        // vertices. Initialize all indegrees as 0.
        val indegree = IntArray(V)

        // Traverse adjacency lists to fill indegrees of
        // vertices. This step takes O(V+E) time
        for (i in 0 until V) {
            val temp = adj[i]
            for (node in temp) {
                indegree[node]++
            }
        }

        val q: Queue<Int> = PriorityQueue<Int>() {
            a, b -> indegree[b] - indegree[a]
        }
        for (i in 0 until V) {
            if (indegree[i] == 0)
                q.add(i)
        }

        var ans = 0
        while (!q.isEmpty()) {
            // Extract front of queue (or perform dequeue)
            // and add it to topological order
            val list = arrayListOf<Int>()
            for (i in 0 until k) {
                if (q.isEmpty()) {
                    break
                }
                val u = q.poll()
                for (node in adj[u]) {
                    if (--indegree[node] == 0)
                        list.add(node)
                }
            }
            list.forEach {
                q.add(it)
            }
            ans++
        }

        return ans
    }
}