package leetcode.contest.cur.leetcode.b36

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5518()
    s.restoreMatrix(
            intArrayOf(3, 8),
            intArrayOf(4, 7)
    ).print()

    s.restoreMatrix(
            intArrayOf(5, 7, 10),
            intArrayOf(8, 6, 8)
    ).print()

    s.restoreMatrix(
            intArrayOf(1, 0),
            intArrayOf(1)
    ).print()
}

class Solution5518 {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val m = rowSum.size
        val n = colSum.size
        val matrix = Array<IntArray>(m) { IntArray(n) }
        fun dfs(i: Int, j: Int) {
            if (i !in rowSum.indices || j !in colSum.indices) {
                return
            }
            if (rowSum[i] > colSum[j]) {
                matrix[i][j] = colSum[j]
                rowSum[i] -= matrix[i][j]
                dfs(i, j + 1)
            } else if (rowSum[i] < colSum[j]) {
                matrix[i][j] = rowSum[i]
                colSum[j] -= matrix[i][j]
                dfs(i + 1, j)
            } else {
                matrix[i][j] = rowSum[i]
                dfs(i + 1, j + 1)
            }
        }
        dfs(0, 0)
        return matrix
    }
}