package leetcode.contest.last.c179

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5355()
    s.frogPosition(7, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 7),
            intArrayOf(2, 4),
            intArrayOf(2, 6),
            intArrayOf(3, 5)
    ), 2, 4).print()

    s.frogPosition(3, arrayOf(
            intArrayOf(2, 1),
            intArrayOf(3, 2)
    ), 1, 2).print()
}

class Solution5355 {
    fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {
        val map = HashMap<Int, ArrayList<Int>>()
        edges.forEach {
            it.sort()
            map[it[0]] = map.getOrDefault(it[0], arrayListOf())
            map[it[0]]!!.add(it[1])
        }

        val queue: Queue<Pair<Int, Double>> = LinkedList<Pair<Int, Double>>()
        queue.add(Pair(1, 1.0))
        var step = -1
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            if (step == t) {
                return if (target in queue.map { it.first }) {
                    queue.first { it.first == target }.second
                } else {
                    0.0
                }
            }
            for (i in 0 until size) {
                val item = queue.poll()

                val d = item.second
                map[item.first]?.forEach {
                    queue.offer(Pair(it, d / map[item.first]!!.size))
                }
                if (item.first !in map.keys) {
                    queue.offer(item)
                }
            }
        }
        return 0.0
    }
}