package leetcode.contest.last.c191

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5426()
    s.minReorder(6, arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(4, 0),
            intArrayOf(4, 5)
    )).print()
}

class Solution5426 {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val map0 = HashMap<Int, ArrayList<Int>>()
        val map1 = HashMap<Int, ArrayList<Int>>()
        connections.forEach {
            map0[it[0]] = map0.getOrDefault(it[0], arrayListOf())
            map0[it[0]]!!.add(it[1])
            map1[it[1]] = map1.getOrDefault(it[1], arrayListOf())
            map1[it[1]]!!.add(it[0])
        }
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(0)
        var ans = 0
        val seen = HashSet<Int>()
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item in seen) {
                    continue
                }
                map1.getOrDefault(item, arrayListOf()).forEach {
                    queue.offer(it)
                }
                map0.getOrDefault(item, arrayListOf()).forEach {
                    if (it !in seen) {
                        ans++
                        queue.offer(it)
                    }
                }
                seen.add(item)
            }
        }
        return ans
    }
}