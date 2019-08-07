package leetcode.normal

import leetcode.contest.utils.print
import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) {
    val s = Solution767()
    s.reorganizeString("abcccca").print()
}

class Solution767 {
    fun reorganizeString(S: String): String {
        val map = hashMapOf<Char, Int>()
        S.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        if (map.values.max()!! > (S.length + 1) / 2) {
            return ""
        }

        val pq = PriorityQueue<Pair<Char, Int>>(compareBy { -it.second })
        map.forEach { t, u ->
            pq.offer(Pair(t, u))
        }

        val sb = StringBuilder()
        var pre = ' '
        for (i in 0 until S.length) {
            val item = pq.poll()
            if (item.first != pre) {
                sb.append(item.first)
                pre = item.first
                pq.offer(Pair(item.first, item.second - 1))
            } else {
                sb.append(pq.peek().first)
                val sec = pq.poll()
                pq.offer(item)
                pq.offer(Pair(sec.first, sec.second - 1))
                pre = sec.first
            }
        }
        return sb.toString()
    }
}