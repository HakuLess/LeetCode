package leetcode.contest.last.c226

import java.util.*

class Solution5666 {
    fun checkPartitioning(word: String): Boolean {
        val n = word.length
        val isPal = Array(n) { BooleanArray(n) }
        for (i in 0 until n) {
            for (j in 0..i) {
                if (word[j] == word[i] && (i - j < 2 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true
                }
            }
        }
        val last = ArrayList<Int>()
        for (i in 0 until n) {
            if (isPal[i][n - 1]) last.add(i)
        }
        for (l in last) {
            for (i in 0 until l) {
                if (isPal[0][i] && isPal[i + 1][l - 1]) {
                    return true
                }
            }
        }
        return false
    }
}