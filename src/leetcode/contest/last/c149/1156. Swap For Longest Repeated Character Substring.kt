package leetcode.contest.last.c149

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1156()
    s.maxRepOpt1("ababa").print()
    s.maxRepOpt1("aaabaaa").print()
    s.maxRepOpt1("aaabbaaa").print()
    s.maxRepOpt1("aaaaa").print()
    s.maxRepOpt1("abcdef").print()
    s.maxRepOpt1("aaaaabbbbbbaabbaabbaaabbbbab").print()
}

class Solution1156 {
    fun maxRepOpt1(text: String): Int {
        var ans = 0
        for (c in 'a'..'z') {
            ans = maxOf(ans, getMax(text, c))
        }
        return ans
    }

    private fun getMax(text: String, a: Char): Int {
        var max = 0
        val queue: Queue<Char> = LinkedList()

        for (i in 0..text.lastIndex) {
            if (text[i] == a) {
                queue.offer(text[i])
            } else {
                if (queue.isEmpty()) {
                    continue
                }
                while (queue.any { it != a }) {
                    queue.poll()
                }
                queue.offer(text[i])
            }
            max = maxOf(max, queue.size)
        }
        return minOf(max, text.count { it == a })
    }
}