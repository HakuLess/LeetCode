package leetcode.contest.cur.leetcode.c206

class Solution5511 {
    fun numSpecial(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val rows = IntArray(m) { 0 }
        val cols = IntArray(n) { 0 }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 1) {
                    rows[i]++
                    cols[j]++
                }
            }
        }
        var ans = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) ans++
            }
        }
        return ans
    }
}