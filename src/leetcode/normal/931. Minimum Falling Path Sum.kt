package leetcode.normal

class Solution931 {
    fun minFallingPathSum(A: Array<IntArray>): Int {
        if (A.isEmpty() || A[0].isEmpty()) {
            return 0
        }
        val x = A.size
        val y = A[0].size
        val matrix = Array(x) { IntArray(y) }
        for (i in 0 until y) {
            matrix[0][i] = A[0][i]
        }
        for (i in 1 until x) {
            for (j in 0 until y) {
                matrix[i][j] = matrix[i - 1][j]
                if (j > 0) {
                    matrix[i][j] = minOf(matrix[i - 1][j - 1], matrix[i][j])
                }
                if (j < y - 1) {
                    matrix[i][j] = minOf(matrix[i - 1][j + 1], matrix[i][j])
                }
                matrix[i][j] += A[i][j]
            }
        }
        return matrix[x - 1].minOrNull()!!
    }
}