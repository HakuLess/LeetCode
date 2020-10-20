package leetcode.contest.cur.leetcode.c211

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5544()
//    s.findLexSmallestString("5525", 9, 2).print()
    s.findLexSmallestString("43987654", 7, 3).print()
}

class Solution5544 {
    fun findLexSmallestString(s: String, a: Int, b: Int): String {
        val queue: Queue<String> = LinkedList<String>()
        queue.add(s)
        var ans = s
        val seen = HashSet<String>()
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item in seen) continue
                seen.add(item)
                ans = minOf(ans, item)
                item.toCharArray().mapIndexed { index, c ->
                    if (index % 2 == 0) {
                        c
                    } else {
                        ((c - '0') + a) % 10
                    }
                }.joinToString("").also {
                    if (it !in seen)
                        queue.offer(it)
                }
                (item.substring(b, item.length) + item.substring(0, b)).also {
                    if (it !in seen)
                        queue.offer(it)
                }
            }
        }
        return ans
    }
}