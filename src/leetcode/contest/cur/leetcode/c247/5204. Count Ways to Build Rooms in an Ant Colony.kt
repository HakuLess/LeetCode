package leetcode.contest.cur.leetcode.c247

import leetcode.contest.utils.Graph
import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5204()
    s.waysToBuildRooms(intArrayOf(-1, 0, 1)).print()
    s.waysToBuildRooms(intArrayOf(-1, 0, 0, 1, 2)).print()
    s.waysToBuildRooms(intArrayOf(-1, 0, 0, 0, 0)).print()
}

class Solution5204 {
    val mod = 1000000007L

    fun waysToBuildRooms(prevRoom: IntArray): Int {
        val cur = LongArray(prevRoom.size) { 1L }
        val g = Graph(prevRoom.size)
        for (i in prevRoom.indices) {
            if (prevRoom[i] == -1) continue
            g.addEdgeOri(prevRoom[i], i)
        }

        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(0)
        val map = HashMap<Long, Long>()
        var step = 0L
        while (queue.isNotEmpty()) {
            step++
            map[step] = queue.size.toLong()
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                g.adj[item].forEach {
                    queue.offer(it)
                }
            }
        }

        println(map)
        var ans = 0L
        var route = 1L
        map.forEach { l, l2 ->
            if (l == step) {
                ans = getFac(l2) * route % mod
            } else {
                route = route * getFac(l2) % mod
            }
        }
        return ans.toInt()
    }

    fun getFac(i: Long): Long {
        var ans = 1L
        for (j in 1..i) {
            ans *= j
            ans %= mod
        }
        return ans
    }
}