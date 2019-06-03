package leetcode.contest.c139

import java.lang.StringBuilder

class Solution1072 {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val m = matrix[0].size

        val map = HashMap<String, Int>()
        for (i in 0 until n) {
            val a0 = StringBuilder()
            val a1 = StringBuilder()
            for (j in 0 until m) {
                a0.append(matrix[i][j])
                a1.append(1 - matrix[i][j])
            }
            map[a0.toString()] = map.getOrDefault(a0.toString(), 0) + 1
            map[a1.toString()] = map.getOrDefault(a1.toString(), 0) + 1
        }

        return map.values.max()!!
    }
}