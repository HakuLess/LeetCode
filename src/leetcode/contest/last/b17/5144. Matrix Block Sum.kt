package leetcode.contest.last.b17

class Solution5144 {
    fun matrixBlockSum(mat: Array<IntArray>, K: Int): Array<IntArray> {
        val ans = Array<IntArray>(mat.size) { IntArray(mat[0].size) }
        fun dfs(i: Int, j: Int, K: Int, mat: Array<IntArray>): Int {
            var res = 0
            for (a in i - K..i + K) {
                for (b in j - K..j + K) {
                    if (a in mat.indices && b in mat[0].indices) {
                        res += mat[a][b]
                    }
                }
            }
            return res
        }
        for (i in mat.indices) {
            for (j in mat[0].indices) {
                ans[i][j] = dfs(i, j, K, mat)
            }
        }
        return ans
    }
}