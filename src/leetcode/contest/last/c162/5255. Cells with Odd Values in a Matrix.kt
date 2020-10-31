package leetcode.contest.last.c162

class Solution5255 {
    fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {
        val matrix = Array<IntArray>(n) { IntArray(m) { 0 } }
        for (i in 0 until n) {
            for (j in 0 until m) {
                matrix[i][j] += indices.count { it[0] == i }
                matrix[i][j] += indices.count { it[1] == j }
            }
        }
        var ans = 0
        matrix.forEach {
            ans += it.count { it % 2 == 1 }
        }
        return ans
    }
}