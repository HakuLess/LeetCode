package leetcode.contest.cur.leetcode.c244

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5776()
    s.findRotation("[[0,0,0],[0,1,0],[1,1,1]]".toGrid(), "[[1,1,1],[0,1,0],[0,0,0]]".toGrid()).print()
}

class Solution5776 {
    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val n = mat.size
        var ans = true
        for (c in 0 until 4) {
            ans = true
            rotate(mat)
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (mat[i][j] != target[i][j]) {
                        ans = false
                    }
                }
            }
            if (ans)
                return true
        }
        return false
    }

    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        for (i in 0 until (n + 1) / 2) {
            for (j in 0 until n / 2) {
                val temp = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1]
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = matrix[i][j]
                matrix[i][j] = temp
            }
        }
    }
}