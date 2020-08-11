package leetcode.contest.last.c136

import leetcode.contest.utils.SuffixArray
import leetcode.contest.utils.print

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
        for (i in lcp.indices) {
            if (lcp[i] > max) {
                max = lcp[i]
                start = suffixArray[i].index
            }
        }
        return S.substring(start, start + max)
    }
}