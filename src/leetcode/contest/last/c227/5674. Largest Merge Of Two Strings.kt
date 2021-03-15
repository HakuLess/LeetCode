package leetcode.contest.last.c227

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5674()
    s.largestMerge("cabaa", "bcaaa").print()
}

class Solution5674 {
    fun largestMerge(word1: String, word2: String): String {
        var a = word1
        var b = word2
        val c = StringBuilder()
        while (a.isNotEmpty() && b.isNotEmpty()) {
            if (a > b) {
                c.append(a[0])
                a = a.substring(1)
            } else {
                c.append(b[0])
                b = b.substring(1)
            }
        }
        c.append(a)
        c.append(b)
        return c.toString()
    }
}