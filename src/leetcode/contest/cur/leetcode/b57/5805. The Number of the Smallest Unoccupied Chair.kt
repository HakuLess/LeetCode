package leetcode.contest.cur.leetcode.b57

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5805()
    s.smallestChair("[[1,4],[2,3],[4,6]]".toGrid(), 1).print()
}

class Solution5805 {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val n = times.size
        val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy({ it.first }, { it.second }))
        for (i in times.indices) {
            pq.offer(Triple(times[i][0], 1, i))
            pq.offer(Triple(times[i][1], -1, i))
        }
        val ts = TreeSet<Int>()
        val seat = IntArray(n) { -1 }
        for (i in 0..n) ts.add(i)
        while (pq.isNotEmpty()) {
            val item = pq.poll()
            if (item.second == 1) {
                seat[item.third] = ts.pollFirst()!!
                if (item.third == targetFriend) return seat[item.third]
            } else {
                ts.add(seat[item.third])
            }
        }
        return -1
    }
}