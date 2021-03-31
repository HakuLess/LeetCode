package leetcode.contest.cur.leetcode.c234

import java.math.BigInteger

class Solution5713 {
    fun numDifferentIntegers(word: String): Int {
        var cur = ""
        val ans = hashSetOf<BigInteger>()
        for (i in word.indices) {
            if (word[i] in '0'..'9') {
                cur += word[i]
            }
            if (word[i] !in '0'..'9' || i == word.lastIndex) {
                cur.toBigIntegerOrNull()?.let {
                    ans.add(it)
                }
                cur = ""
            }
        }
        return ans.size
    }
}