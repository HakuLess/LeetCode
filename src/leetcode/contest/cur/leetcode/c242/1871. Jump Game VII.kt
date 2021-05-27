package leetcode.contest.cur.leetcode.c242

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution1871()
    s.canReach("011010", 2, 3).print()
    s.canReach("01101110", 2, 3).print()
}

class Solution1871 {
    fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        val l = ArrayList<Int>()
        for (i in s.indices) {
            if (s[i] == '0') l.add(i)
        }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        pq.offer(Pair(minJump, maxJump))
        for (i in 1 until l.size) {
            if (pq.isEmpty()) return false
            while (l[i] > pq.peek().second) {
                pq.poll()
                if (pq.isEmpty()) return false
            }
            if (l[i] < pq.peek().first) {
                continue
            } else {
                if (l[i] == s.lastIndex) {
                    return true
                }
                pq.offer(Pair(l[i] + minJump, l[i] + maxJump))
            }
        }
        return false
    }
}