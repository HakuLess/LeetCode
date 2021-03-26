package leetcode.contest.last.c138

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val a = Solution1054()
    a.rearrangeBarcodes(intArrayOf(1, 1, 1, 1, 2, 2, 3, 3)).print()
}

class Solution1054 {
    fun rearrangeBarcodes(barcodes: IntArray): IntArray {
        val pq = PriorityQueue<IntArray>(compareBy { -it[1] })
        val map = HashMap<Int, Int>()
        barcodes.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        map.forEach { (t, u) ->
            pq.offer(intArrayOf(t, u))
        }
        val ans = ArrayList<Int>()
        while (pq.isNotEmpty()) {
            val first = pq.poll()
            if (first[0] != ans.lastOrNull()) {
                ans.add(first[0])
                if (first[1] > 1) {
                    pq.offer(intArrayOf(first[0], first[1] - 1))
                }
            } else {
                val sec = pq.poll()
                ans.toIntArray().print()
                ans.add(sec[0])
                if (sec[1] > 1) {
                    pq.offer(intArrayOf(sec[0], sec[1] - 1))
                }
                pq.offer(first)
            }
        }
        return ans.toIntArray()
    }
}