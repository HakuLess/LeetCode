package leetcode.normal

import kotlin.collections.HashMap

class Solution766 {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        val seen = HashMap<Int, Int>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if ((i - j) in seen.keys) {
                    if (seen[i - j] != matrix[i][j]) return false
                } else {
                    seen[i - j] = matrix[i][j]
                }
            }
        }
        return true
    }
}