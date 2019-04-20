package leetcode.normal

import leetcode.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution819()
    s.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
            arrayOf("hit")).print()

    s.mostCommonWord("a, a, a, a, b,b,b,c, c",
            arrayOf("a")).print()
}

class Solution819 {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val pq = PriorityQueue<Pair<String, Int>>(compareBy { -it.second })

        val map = hashMapOf<String, Int>()
        String(paragraph.toLowerCase()
                .replace(',', ' ')
                .replace('.', ' ')
                .toCharArray().filter {
                    it in 'a'..'z' || it == ' '
                }.toCharArray()).split(' ').forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        map.print()
        map.forEach { t, u ->
            if (t.isNotBlank()) {
                pq.offer(Pair(t, u))
            }
        }

        while (pq.peek().first in banned) {
            pq.poll()
        }
        return if (pq.isEmpty()) {
            ""
        } else {
            pq.peek().first
        }
    }
}