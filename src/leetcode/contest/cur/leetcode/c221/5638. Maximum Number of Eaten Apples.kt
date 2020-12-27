package leetcode.contest.cur.leetcode.c221

import leetcode.contest.utils.print
import leetcode.contest.utils.toIntArray
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5638()
    s.eatenApples(
            "[1,2,3,5,2]".toIntArray(),
            "[3,2,1,4,2]".toIntArray()
    ).print()
}

class Solution5638 {
    fun eatenApples(apples: IntArray, days: IntArray): Int {
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        var ans = 0
        var i = 0
        while (i in apples.indices || pq.isNotEmpty()) {
            while (pq.isNotEmpty() && pq.peek().first <= i) {
                pq.poll()
            }
            if (i in apples.indices && apples[i] != 0) {
                pq.offer(Pair(i + days[i], apples[i]))
            }
            if (pq.isNotEmpty()) {
                val item = pq.poll()
                if (item.second > 1) {
                    pq.offer(Pair(item.first, item.second - 1))
                }
                ans++
            }
            i++
        }
        return ans
    }
}