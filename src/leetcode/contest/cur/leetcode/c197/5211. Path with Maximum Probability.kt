package leetcode.contest.cur.leetcode.c197

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution52111()
    s.maxProbability(3, arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(0, 2)),
            arrayOf(0.5, 0.5, 0.2).toDoubleArray(), 0, 2).print()
}

class Solution52111 {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
        val map = HashMap<Int, ArrayList<Pair<Int, Double>>>()
        for (i in edges.indices) {
            map[edges[i][0]] = map.getOrDefault(edges[i][0], arrayListOf())
            map[edges[i][0]]!!.add(Pair(edges[i][1], succProb[i]))
            map[edges[i][1]] = map.getOrDefault(edges[i][1], arrayListOf())
            map[edges[i][1]]!!.add(Pair(edges[i][0], succProb[i]))
        }

        map.forEach { i, arrayList ->
            println("$i:")
            arrayList.forEach {
                println(it)
            }
        }
        val seen = HashMap<Int, Double>()
        val queue: Queue<Pair<Int, Double>> = LinkedList<Pair<Int, Double>>()
        queue.add(Pair(start, 1.0))
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first !in map.keys) {
                    continue
                }
                map[item.first]!!.forEach {
                    if (it.first !in seen.keys || item.second * it.second > seen[it.first]!!) {
                        queue.offer(Pair(it.first, it.second * item.second))
                        seen[it.first] = it.second * item.second
                        println("add ${it.first} with ${it.second} * ${item.second}")
                    }
                }
            }
        }
        return if (end !in seen.keys) 0.0 else seen[end]!!
    }
}