package leetcode.contest.utils

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Graph(val n: Int) {

    // 图中边（可以有方向）
    var adj: Array<LinkedList<Int>> = Array(n) { LinkedList<Int>() }

    // 图中边的权重（可以有方向）
    val weight = HashMap<Int, HashMap<Int, Int>>()

    init {
        for (i in 0 until n) {
            weight[i] = hashMapOf()
        }
    }

    fun addEdgeOri(i: Int, j: Int, w: Int = 0) {
        adj[i].add(j)
        weight[i]!![j] = w
    }

    fun addEdge(i: Int, j: Int, w: Int = 0) {
        // Add w to v's list.
        adj[i].add(j)
        // Add v to w's list
        adj[j].add(i)
        weight[i]!![j] = w
        weight[j]!![i] = w
    }
}

/**
 * 堆优化Dijkstra 单源最短路径
 * @param source 源点(0..n-1)
 * */
fun Graph.dijkstra(source: Int): IntArray {
    // 距离source的最短路径
    val ans = IntArray(n) { Int.MAX_VALUE / 2 }
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    pq.offer(Pair(source, 0))
    while (pq.isNotEmpty()) {
        val (item, dis) = pq.poll()
        if (ans[item] <= dis) continue
        ans[item] = dis
        this.adj[item].forEach {
            if (ans[it] >= Int.MAX_VALUE / 2)
                pq.offer(Pair(it, dis + weight[item]!![it]!!))
        }
    }
    return ans
}

// prints a Topological Sort of the complete graph
fun Graph.topologicalSort(): ArrayList<Int> {
    // Create a array to store indegrees of all
    // vertices. Initialize all indegrees as 0.
    val indegree = IntArray(n)

    // Traverse adjacency lists to fill indegrees of
    // vertices. This step takes O(V+E) time
    for (i in 0 until n) {
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
    for (i in 0 until n) {
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
    if (cnt != n) {
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