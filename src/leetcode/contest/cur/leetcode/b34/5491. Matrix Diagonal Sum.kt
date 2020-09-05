package leetcode.contest.cur.leetcode.b34

class Solution5491 {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var ans = 0
        val n = mat.size - 1
        val seen = HashSet<Pair<Int, Int>>()
        for (i in mat.indices) {
            ans += mat[i][i]
            seen.add(Pair(i, i))
            ans += mat[n - i][i]
        }
        return ans
    }
}