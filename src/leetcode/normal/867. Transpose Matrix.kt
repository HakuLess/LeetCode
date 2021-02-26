package leetcode.normal

class Solution867 {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val ans = Array<IntArray>(matrix[0].size) { IntArray(matrix.size) }
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                ans[j][i] = matrix[i][j]
            }
        }
        return ans
    }
}