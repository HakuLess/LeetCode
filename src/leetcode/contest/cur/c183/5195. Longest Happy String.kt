package leetcode.contest.cur.c183

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5195()
    s.longestDiverseString(1, 1, 7).print()
    s.longestDiverseString(7, 1, 0).print()
}

class Solution5195 {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val pq = PriorityQueue<Pair<Char, Int>>(compareBy { -it.second })
        if (a != 0)
            pq.add(Pair('a', a))
        if (b != 0)
            pq.add(Pair('b', b))
        if (c != 0)
            pq.add(Pair('c', c))
        var ans = ""
        while (pq.isNotEmpty()) {
            val item = pq.poll()
            if (ans.length >= 2 && ans[ans.lastIndex] == item.first && ans[ans.lastIndex - 1] == item.first) {
                if (pq.isNotEmpty()) {
                    val it = pq.poll()
                    ans += it.first
                    if (it.second != 1) {
                        pq.add(Pair(it.first, it.second - 1))
                    }
                } else {
                    return ans
                }
                pq.add(item)
                continue
            }
            ans += item.first
            if (item.second != 1) {
                pq.add(Pair(item.first, item.second - 1))
            }
        }
        return ans
    }
}