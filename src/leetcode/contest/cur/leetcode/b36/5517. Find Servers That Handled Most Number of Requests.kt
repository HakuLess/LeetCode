package leetcode.contest.cur.leetcode.b36

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution5517()
//    s.busiestServers(3, intArrayOf(1, 2, 3), intArrayOf(10, 12, 11)).joinToString(", ").print()
//    s.busiestServers(3, intArrayOf(1, 2, 3, 4), intArrayOf(1, 2, 1, 2)).joinToString(", ").print()
    s.busiestServers(3, intArrayOf(1, 2, 3, 4, 8, 9, 10), intArrayOf(5, 2, 10, 3, 1, 2, 2)).joinToString(", ").print()


    s.busiestServers(2, intArrayOf(1, 3, 5, 6, 7, 12), intArrayOf(3, 4, 6, 5, 5, 6)).joinToString(", ").print()
}

class Solution5517 {
    fun busiestServers(k: Int, arrival: IntArray, load: IntArray): List<Int> {
        val ans = IntArray(k)
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        val set = TreeSet<Int>()
        for (i in 0 until k) {
            set.add(i)
        }
        for (i in arrival.indices) {
            while (!pq.isEmpty() && pq.peek().second <= arrival[i]) {
                set.add(pq.poll().first)
            }
            if (!set.isEmpty()) {
                val cur = set.ceiling(i % k) ?: set.first()
                set.remove(cur)
                pq.add(Pair(cur, arrival[i] + load[i]))
                ans[cur] += 1
            }
        }
        val max = ans.maxOrNull()
        val res = arrayListOf<Int>()
        for (i in ans.indices) {
            if (ans[i] == max) {
                res.add(i)
            }
        }
        return res
    }
}