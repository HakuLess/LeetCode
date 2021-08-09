package leetcode.contest.last.c253

import java.util.*

class Solution5839 {
    fun minStoneSum(piles: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>(compareBy { -it })
        piles.forEach {
            pq.offer(it)
        }
        repeat(k) {
            val item = pq.poll()
            pq.offer((item + 1) / 2)
        }
        return pq.sum()
    }
}