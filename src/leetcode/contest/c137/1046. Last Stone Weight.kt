package leetcode.contest.c137

import leetcode.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1046()
    s.lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)).print()
}

class Solution1046 {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(stones.size, Collections.reverseOrder())
        stones.forEach {
            pq.offer(it)
        }
        while (pq.size > 1) {
            val x = pq.poll()
            val y = pq.poll()
            if (x - y != 0) {
                pq.offer(x - y)
            }
        }
        return if (pq.isEmpty()) {
            0
        } else {
            pq.peek()
        }
    }
}