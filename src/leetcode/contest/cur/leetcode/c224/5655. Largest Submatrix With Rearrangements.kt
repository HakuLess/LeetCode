package leetcode.contest.cur.leetcode.c224

class Solution5655 {
    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        val n: Int = matrix.size
        val m: Int = matrix[0].size
        var res = 0
        for (i in 1 until n) {
            for (j in 0 until m) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j]
                }
            }
        }
        for (i in 0 until n) {
            matrix[i].sortDescending()
            for (j in 0 until m) {
                val height = matrix[i][j]
                res = maxOf(res, height * (j + 1))
            }
        }
        return res
    }
}