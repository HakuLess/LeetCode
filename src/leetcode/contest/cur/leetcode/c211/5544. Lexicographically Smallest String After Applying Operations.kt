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
        val seen = HashSet<String>()
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item in seen) continue
                seen.add(item)

                var add = false
                var next1 = item
                for (i in item.indices) {
                    if (add) {
                        next1 = next1.substring(0, i) + ((next1[i] - '0' + a) % 10) + next1.substring(i + 1, next1.length)
                    }
                    add = !add
                }
                if (next1 !in seen) {
                    queue.offer(next1)
                }
                val next2 = item.substring(b, item.length) + item.substring(0, b)
                if (next2 !in seen) {
                    queue.offer(next2)
                }
            }
        }

        return seen.min()!!
    }
}