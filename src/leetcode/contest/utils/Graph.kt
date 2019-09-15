package leetcode.contest.utils

import java.util.LinkedList


class Graph(private val V: Int) {

    // Array  of lists for Adjacency List Representation
    private var adj: Array<LinkedList<Int>> = Array(V) { LinkedList() }
    var time = 0
    val bridge = arrayListOf<ArrayList<Int>>()

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)       // Add w to v's list.
        adj[w].add(v)       // Add v to w's list
    }

    // A recursive function that finds and prints bridges
    // using DFS traversal
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    private fun bridgeUtil(u: Int, visited: BooleanArray, disc: IntArray,
                           low: IntArray, parent: IntArray) {

        // Mark the current node as visited
        visited[u] = true

        // Initialize discovery time and low value
        low[u] = ++time
        disc[u] = low[u]

        // Go through all vertices a adjacent to this
        val i = adj[u].iterator()
        while (i.hasNext()) {
            val v = i.next()  // v is current adjacent of u

            // If v is not visited yet, then make it a child
            // of u in DFS tree and recur for it.
            // If v is not visited yet, then recur for it
            if (!visited[v]) {
                parent[v] = u
                bridgeUtil(v, visited, disc, low, parent)

                // Check if the subtree rooted with v has a
                // connection to one of the ancestors of u
                low[u] = minOf(low[u], low[v])

                // If the lowest vertex reachable from subtree
                // under v is below u in DFS tree, then u-v is
                // a bridge
                if (low[v] > disc[u]) {
                    println("$u $v")
                    bridge.add(arrayListOf(u, v))
                }
            } else if (v != parent[u]) {
                // Update low value of u for parent function calls.
                low[u] = minOf(low[u], disc[v])
            }
        }
    }

    // DFS based function to find all bridges. It uses recursive
    // function bridgeUtil()
    fun bridge() {
        // Mark all the vertices as not visited
        val visited = BooleanArray(V)
        val disc = IntArray(V)
        val low = IntArray(V)
        val parent = IntArray(V)

        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (i in 0 until V) {
            parent[i] = -1
            visited[i] = false
        }

        // Call the recursive helper function to find Bridges
        // in DFS tree rooted with vertex 'i'
        for (i in 0 until V)
            if (!visited[i])
                bridgeUtil(i, visited, disc, low, parent)
    }
}