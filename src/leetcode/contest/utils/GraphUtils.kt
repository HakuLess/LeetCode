package leetcode.contest.utils

import java.util.*
import kotlin.collections.ArrayList

class Graph(val V: Int) {

    // Array  of lists for Adjacency List Representation
    var adj: Array<LinkedList<Int>> = Array(V) { LinkedList<Int>() }

    fun addEdgeOri(v: Int, w: Int) {
        adj[v].add(w)
    }

    fun addEdge(v: Int, w: Int) {
        // Add w to v's list.
        adj[v].add(w)
        // Add v to w's list
        adj[w].add(v)
    }
}

// prints a Topological Sort of the complete graph
fun Graph.topologicalSort(): ArrayList<Int> {
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

    // Create a queue and enqueue all vertices with
    // indegree 0
    val q: Queue<Int> = PriorityQueue<Int>() { a, b ->
        indegree[b] - indegree[a]
    }
    for (i in 0 until V) {
        if (indegree[i] == 0)
            q.add(i)
    }

    // Initialize count of visited vertices
    var cnt = 0

    // Create a vector to store result (A topological
    // ordering of the vertices)
    val topOrder = ArrayList<Int>()
    while (!q.isEmpty()) {
        // Extract front of queue (or perform dequeue)
        // and add it to topological order
        val u = q.poll()
        topOrder.add(u)

        // Iterate through all its neighbouring nodes
        // of dequeued node u and decrease their in-degree
        // by 1
        for (node in adj[u]) {
            // If in-degree becomes zero, add it to queue
            if (--indegree[node] == 0)
                q.add(node)
        }
        cnt++
    }

    // Check if there was a cycle
    if (cnt != V) {
        println("There exists a cycle in the graph")
        return arrayListOf()
    }

    val ans = arrayListOf<Int>()
    // Print topological order
    for (i in topOrder) {
        ans.add(i)
    }
    return ans
}