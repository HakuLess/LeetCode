package leetcode.contest.cur.b09

import leetcode.contest.utils.print
import leetcode.contest.utils.toArrayList
import java.lang.Exception
import java.util.PriorityQueue


fun main(args: Array<String>) {
    val s = Solution5091()
//    s.minBuildTime(intArrayOf(1, 2, 3), 1).print()
//    s.minBuildTime(intArrayOf(1, 2), 5).print()
//    s.minBuildTime(intArrayOf(1), 1).print()
    s.minBuildTime(intArrayOf(28004, 62141, 95852, 39602, 44613, 41129, 92831, 36944, 80519, 54971), 62).print()
}

class Solution5091 {
    fun minBuildTime(blocks: IntArray, split: Int): Int {
        val pq = PriorityQueue<Int>()
        for (v in blocks) {
            pq.add(v)
        }
        while (pq.size >= 2) {
            pq.poll()
            val y = pq.poll()
            pq.add(y + split)
        }
        return pq.poll()
    }
}