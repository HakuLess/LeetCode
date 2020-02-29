package leetcode.contest.last.c173

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5321()
//    s.findTheCity(4, arrayOf(
//            intArrayOf(0, 1, 3),
//            intArrayOf(1, 2, 1),
//            intArrayOf(1, 3, 4),
//            intArrayOf(2, 3, 1)
//    ), 400).print()

    s.findTheCity(6, arrayOf(
            intArrayOf(0, 3, 7),
            intArrayOf(2, 4, 1),
            intArrayOf(0, 1, 5),
            intArrayOf(2, 3, 10),
            intArrayOf(1, 3, 6),
            intArrayOf(1, 2, 1)
    ), 417).print()

}

class Solution5321 {
    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        val map = HashMap<Int, ArrayList<Pair<Int, Int>>>()
        edges.forEach {
            map[it[0]] = map.getOrDefault(it[0], arrayListOf())
            map[it[0]]!!.add(Pair(it[1], it[2]))
            map[it[1]] = map.getOrDefault(it[1], arrayListOf())
            map[it[1]]!!.add(Pair(it[0], it[2]))
        }
        var min = Int.MAX_VALUE
        var ans = 0
        for (i in 0 until n) {
            val cur = helper(i, distanceThreshold, map)
//            println("$i $cur")
            if (min >= cur) {
                ans = i
                min = cur
            }
        }
        return ans
    }

    private fun helper(index: Int, max: Int, map: HashMap<Int, ArrayList<Pair<Int, Int>>>): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(index, max))
        val seen = HashSet<Int>()
        seen.add(index)
        val seenDis = HashMap<Int, Int>()
        seenDis[index] = max
        while (queue.isNotEmpty()) {
            val size = queue.size
            val t = seen.size
            for (i in 0 until size) {
                val item = queue.poll()
                map[item.first]?.forEach {
                    if (item.second >= it.second && (!seen.contains(it.first) || seenDis[it.first]!! < item.second - it.second)) {
                        queue.offer(Pair(it.first, item.second - it.second))
                        seen.add(it.first)
                        seenDis[it.first] = item.second - it.second
                    }
                }
            }
        }
        return seen.size
    }
}