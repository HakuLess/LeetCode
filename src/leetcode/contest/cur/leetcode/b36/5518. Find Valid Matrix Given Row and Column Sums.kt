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
        for (i in rowSum.indices) {
            for (j in colSum.indices) {
                matrix[i][j] = minOf(rowSum[i], colSum[j])
                rowSum[i] -= matrix[i][j]
                colSum[j] -= matrix[i][j]
            }
        }
        return matrix
    }
}