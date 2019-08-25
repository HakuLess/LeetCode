package leetcode.contest.cur.b07

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1167()
    s.connectSticks(intArrayOf(2, 4, 3)).print()
    s.connectSticks(intArrayOf(1, 8, 3, 5)).print()
}

class Solution1167 {
    fun connectSticks(sticks: IntArray): Int {
        val pq = PriorityQueue<Int>()
        var ans = 0
        sticks.forEach {
            pq.offer(it)
        }
        while (pq.size != 1) {
            val a = pq.poll()
            val b = pq.poll()
            ans += a + b
            pq.offer(a + b)
        }
        return ans
    }
}