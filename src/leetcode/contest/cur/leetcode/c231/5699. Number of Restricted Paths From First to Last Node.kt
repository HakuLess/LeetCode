package leetcode.contest.cur.leetcode.c231

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5699()
//    s.countRestrictedPaths(5, "[[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]".toGrid()).print()
    s.countRestrictedPaths(10, "[[9,10,8],[9,6,5],[1,5,9],[6,8,10],[1,8,1],[8,10,7],[10,7,9],[5,7,3],[4,2,9],[2,3,9],[3,10,4],[1,4,7],[7,6,1],[3,9,8],[9,1,6],[4,7,10],[9,4,9]]".toGrid()).print()

}

class Solution5699 {
    fun countRestrictedPaths(n: Int, edges: Array<IntArray>): Int {
        val mod = 1000000007L
        var ans = 0L

        val map = HashMap<Int, ArrayList<Int>>()
        for (i in 1..n) {
            map[i] = arrayListOf()
        }
        val graph = Array<IntArray>(n + 1) { IntArray(n + 1) { Int.MAX_VALUE / 2 } }
        edges.forEach {
            map[it[0]]!!.add(it[1])
            map[it[1]]!!.add(it[0])
            graph[it[0]][it[1]] = it[2]
            graph[it[1]][it[0]] = it[2]
        }

        val t = ShortestPath(n + 1)
        val dToLast = t.dijkstra(graph, n)

        dToLast.print()
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(1)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                map[item]?.forEach {
                    if (dToLast[it] < dToLast[item]) {
                        queue.offer(it)
                    }
                }
            }
        }

        val arr = IntArray(n + 1) { i -> i }.sortedBy { -dToLast[it] }
        arr.joinToString().print()
        val dp = LongArray(n + 1)
        dp[1] = 1L
        for (x in arr) {
            map[x]?.forEach {
                if (dToLast[it] < dToLast[x]) {
                    dp[it] += dp[x]
                }
            }
        }
        dp.print()
        return (dp[n] % mod).toInt()
//        val seen = HashMap<Int, Long>()
//        fun dfs1(node: Int): Long {
//            if (node in seen) return seen[node]!!
//            if (node == 0) return 0L
//            if (node == n) return 1L
//            var ans = 0L
//            map[node]?.forEach {
//                if (dToLast[it] < dToLast[node]) {
//                    ans += dfs1(it)
//                }
//            }
//            return ans.also {
//                seen[node] = it
//            }
//        }
//        ans = dfs1(1)

//        return (ans % mod).toInt()
    }
}

// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph


internal class ShortestPath(val V: Int) {
    fun minDistance(dist: IntArray, sptSet: Array<Boolean?>): Int {
        // Initialize min value
        var min = Int.MAX_VALUE
        var min_index = -1
        for (v in 0 until V) if (sptSet[v] == false && dist[v] <= min) {
            min = dist[v]
            min_index = v
        }
        return min_index
    }

    // A utility function to print the constructed distance array
    fun printSolution(dist: IntArray) {
        println("Vertex \t\t Distance from Source")
        for (i in 0 until V) println(i.toString() + " \t\t " + dist[i])
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    fun dijkstra(graph: Array<IntArray>, src: Int): IntArray {
        val dist = IntArray(V) // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        val sptSet = arrayOfNulls<Boolean>(V)

        // Initialize all distances as INFINITE and stpSet[] as false
        for (i in 0 until V) {
            dist[i] = Int.MAX_VALUE
            sptSet[i] = false
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0

        // Find shortest path for all vertices
        for (count in 0 until V - 1) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            val u = minDistance(dist, sptSet)

            // Mark the picked vertex as processed
            sptSet[u] = true

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (v in 0 until V)  // Update dist[v] only if is not in sptSet, there is an
            // edge from u to v, and total weight of path from src to
            // v through u is smaller than current value of dist[v]
                if (!sptSet[v]!! && graph[u][v] != 0 && dist[u] != Int.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) dist[v] = dist[u] + graph[u][v]
        }

        // print the constructed distance array
//        printSolution(dist)
        return dist
    }
}
// This code is contributed by Aakash Hasija
