package leetcode.contest.last.c158

import kotlin.collections.ArrayList

class Solution5223 {
    fun queensAttacktheKing(queens: Array<IntArray>, king: IntArray): List<List<Int>> {
        val ans = ArrayList<ArrayList<Int>>()
        val seen = BooleanArray(8) { false }
        for (i in 1 until 8) {
            if (queens.any { it[0] == king[0] && it[1] == king[1] + i } && !seen[0]) {
                ans.add(arrayListOf(king[0], king[1] + i))
                seen[0] = true
            }
            if (queens.any { it[0] == king[0] && it[1] == king[1] - i } && !seen[1]) {
                ans.add(arrayListOf(king[0], king[1] - i))
                seen[1] = true
            }
            if (queens.any { it[0] == king[0] + i && it[1] == king[1] } && !seen[2]) {
                ans.add(arrayListOf(king[0] + i, king[1]))
                seen[2] = true
            }
            if (queens.any { it[0] == king[0] - i && it[1] == king[1] } && !seen[3]) {
                ans.add(arrayListOf(king[0] - i, king[1]))
                seen[3] = true
            }
            if (queens.any { it[0] == king[0] + i && it[1] == king[1] + i } && !seen[4]) {
                ans.add(arrayListOf(king[0] + i, king[1] + i))
                seen[4] = true
            }
            if (queens.any { it[0] == king[0] - i && it[1] == king[1] - i } && !seen[5]) {
                ans.add(arrayListOf(king[0] - i, king[1] - i))
                seen[5] = true
            }
            if (queens.any { it[0] == king[0] - i && it[1] == king[1] + i } && !seen[6]) {
                ans.add(arrayListOf(king[0] - i, king[1] + i))
                seen[6] = true
            }
            if (queens.any { it[0] == king[0] + i && it[1] == king[1] - i } && !seen[7]) {
                ans.add(arrayListOf(king[0] + i, king[1] - i))
                seen[7] = true
            }
        }
        return ans
    }
}