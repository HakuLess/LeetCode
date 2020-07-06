package leetcode.contest.cur.leetcode.c196

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5454()
    s.numSubmat(arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0)
    )).print()
}

class Solution5454 {
    fun numSubmat(mat: Array<IntArray>): Int {
        val dp = Array<IntArray>(mat.size) { IntArray(mat[0].size) }
        for (i in mat.indices) {
            for (j in mat[0].indices.reversed()) {
                if (mat[i][j] == 0) continue
                if (j != mat[0].lastIndex) dp[i][j] += dp[i][j + 1]
                dp[i][j] += if (mat[i][j] == 1) 1 else 0
            }
        }

        var ans = 0
        for (j in mat[0].indices) {
            var i = mat.lastIndex
            val q = Stack<Pair<Int, Int>>()
            var sum = 0
            while (i >= 0) {
                var c = 0
                while (q.size != 0 && q.peek().first > dp[i][j]) {
                    sum -= (q.peek().second + 1) * (q.peek().first - dp[i][j])
                    c += q.peek().second + 1
                    q.pop()
                }
                sum += dp[i][j]
                ans += sum
                ans.print()
                q.add(Pair(dp[i][j], c))
                i--
            }
        }
        dp.print()
        return ans
    }
}