package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution792()
    s.numMatchingSubseq("abcde", arrayOf("a", "bb", "acd", "ace")).print()
}

class Solution792 {
    fun numMatchingSubseq(S: String, words: Array<String>): Int {
        var ans = 0
        words.forEach {
            if (isSub(S, it)) {
                ans++
            }
        }
        return ans
    }

    private fun isSub(a: String, b: String): Boolean {
        var j = 0
        for (i in 0 until a.length) {
            if (a[i] == b[j]) {
                j++
            }
            if (j == b.length) {
                return true
            }
        }
        return false
    }
}