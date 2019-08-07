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
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { -it.second })
        val map = HashMap<Int, Int>()
        barcodes.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        map.forEach { (t, u) ->
            pq.offer(Pair(t, u))
        }

        var pre = -1
        val ans = ArrayList<Int>()

        for (i in 0 until barcodes.size) {
            val item = pq.poll()
            if (item.first != pre) {
                ans.add(item.first)
                pre = item.first
                pq.offer(Pair(item.first, item.second - 1))
            } else {
                val sec = pq.poll()
                pq.offer(item)
                pq.offer(Pair(sec.first, sec.second - 1))
                pre = sec.first
                ans.add(sec.first)
            }
        }

        return ans.toIntArray()
    }
}