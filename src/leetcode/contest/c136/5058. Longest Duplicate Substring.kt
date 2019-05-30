package leetcode.contest.c136

import leetcode.SuffixArray
import leetcode.print
import leetcode.printSuffix

fun main(args: Array<String>) {
    val a = Solution5058()
//    a.longestDupSubstring("abcd").print()
    a.longestDupSubstring("banana").print()
    a.longestDupSubstring("aaaa").print()
}

class Solution5058 {
    fun longestDupSubstring(S: String): String {
        SuffixArray(S).getSuffixArray().printSuffix()

        val lcp = SuffixArray(S).kasai()
        lcp.forEach {
            println(it)
        }
        var max = 0
        var start = 0
        for (i in 0 until lcp.size) {
            if (lcp[i] > max) {
                max = lcp[i]
                start = i
            }
        }
        return S.substring(start, start + max)
    }
}