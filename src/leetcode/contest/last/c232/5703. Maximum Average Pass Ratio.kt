package leetcode.contest.last.c232

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5703()
    s.maxAverageRatio("[[1,2],[3,5],[2,2]]".toGrid(), 2).print()
}

class Solution5703 {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        var ans = 0.0
        val n = classes.size
        val pq = PriorityQueue<Pair<Int, Int>>(compareByDescending {
            (it.first + 1).toDouble() / (it.second + 1).toDouble() - it.first.toDouble() / it.second.toDouble()
        })
        for (i in 0 until n) {
            val it = classes[i]
            ans += it[0].toDouble() / it[1].toDouble()
            pq.offer(Pair(it[0], it[1]))
        }
        var left = extraStudents
        while (left != 0) {
            val it = pq.poll()
            ans += (it.first + 1).toDouble() / (it.second + 1).toDouble() - it.first.toDouble() / it.second.toDouble()
            left--
            pq.offer(Pair(it.first + 1, it.second + 1))
        }
        return ans / n
    }
}