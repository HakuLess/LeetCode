package leetcode.normal

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution815()
    s.numBusesToDestination("[[1,2,7],[3,6,7]]".toGrid(), 1, 6).print()
}

class Solution815 {
    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        if (source == target) return 0
        val map = HashMap<Int, HashSet<Int>>()
        val n = routes.size
        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                if (routes[i].intersect(routes[j].toSet()).isNotEmpty()) {
                    map[i] = map.getOrDefault(i, hashSetOf())
                    map[i]!!.add(j)
                    map[j] = map.getOrDefault(j, hashSetOf())
                    map[j]!!.add(i)
                }
            }
        }

        val queue: Queue<Int> = LinkedList<Int>()
        val targets = hashSetOf<Int>()
        for (i in routes.indices) {
            if (routes[i].contains(source)) queue.add(i)
            if (routes[i].contains(target)) targets.add(i)
        }
        val seen = HashSet<Int>()
        var step = 0
        while (queue.isNotEmpty()) {
            step++
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item in targets) return step
                seen.add(item)
                map[item]?.forEach {
                    if (it !in seen) {
                        queue.offer(it)
                    }
                }
            }
        }
        return -1
    }
}