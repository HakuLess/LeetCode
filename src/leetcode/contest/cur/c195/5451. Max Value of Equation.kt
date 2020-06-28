package leetcode.contest.cur.c195

import java.util.*

class Solution5451 {
    fun findMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))
        var ans = Int.MIN_VALUE
        points.forEach {
            val x = it[0]
            val y = it[1]
            while (pq.isNotEmpty() && pq.peek().second < x - k) pq.poll()
            if (pq.isNotEmpty()) {
                ans = maxOf(ans, pq.peek().first + y + x)
            }
            pq.add(Pair(y - x, x))
        }
        return ans
    }
}