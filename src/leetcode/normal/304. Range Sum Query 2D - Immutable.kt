package leetcode.normal

class NumMatrix(val matrix: Array<IntArray>) {

    var dp: Array<IntArray> = Array<IntArray>(0) { IntArray(0) }

    init {
        if (matrix.isNotEmpty() && matrix[0].isNotEmpty()) {
            dp = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }
            for (r in matrix.indices) {
                for (c in matrix[0].indices) {
                    dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c]
                }
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1]
    }
}
