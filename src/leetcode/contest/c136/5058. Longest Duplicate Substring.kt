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
        val suf = SuffixArray(S)
        val suffixArray = suf.getSuffixArray()

        val lcp = suf.kasai()
        var max = 0
        var start = 0
        for (i in 0 until lcp.size) {
            if (lcp[i] > max) {
                max = lcp[i]
                start = suffixArray[i].index
            }
        }
        return S.substring(start, start + max)
    }
}