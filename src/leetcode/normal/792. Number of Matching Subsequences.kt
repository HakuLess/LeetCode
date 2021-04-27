package leetcode.normal

import leetcode.contest.utils.isSubSeqOf
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution792()
    s.numMatchingSubseq("abcde", arrayOf("a", "bb", "acd", "ace")).print()
}

class Solution792 {
    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        return words.count { it.isSubSeqOf(s) }
    }
}