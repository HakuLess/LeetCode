package leetcode.contest.cur.leetcode.b34

class Solution5491 {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var ans = 0
        val n = mat.size - 1
        for (i in mat.indices) {
            ans += mat[i][i]
            ans += mat[n - i][i]
        }
        if (n % 2 == 0) {
            ans -= mat[n / 2][n / 2]
        }
        return ans
    }
}