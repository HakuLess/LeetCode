package leetcode.contest.last.c221

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5210()
    s.findBall("[[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]".toGrid()).print()
    s.findBall("[[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]".toGrid()).print()
}

class Solution5210 {
    fun findBall(grid: Array<IntArray>): IntArray {
        val n = grid.size
        val m = grid[0].size
        val dp = Array<IntArray>(n) { IntArray(m) }
        for (i in 0 until n)
            for (j in 0 until m)
                dp[i][j] = when {
                    grid[i][j] == 1 -> if (j + 1 < m && grid[i][j + 1] == 1) 1 else 0
                    else -> if (j > 0 && grid[i][j - 1] == -1) -1 else 0
                }
        val ans = arrayListOf<Int>()
        fun dfs(i: Int, j: Int) {
            if (i == n) {
                ans.add(j)
                return
            }
            if (dp[i][j] == 0) {
                ans.add(-1)
                return
            }
            dfs(i + 1, j + dp[i][j])
        }
        for (i in 0 until m) {
            dfs(0, i)
        }
        return ans.toIntArray()
    }

//    fun findBall(grid: Array<IntArray>): IntArray {
//        val ans = arrayListOf<Int>()
//        val m = grid.size
//        val n = grid[0].size
//        val seen = HashMap<String, Int>()
//        fun dfs(i: Int, j: Int): Int {
//            val key = "$i,$j"
//            if (key in seen) {
//                return seen[key]!!
//            }
//            if (i == m) return j
//            return if (grid[i][j] == 1) {
//                if (j + 1 < n && grid[i][j + 1] == 1) {
//                    dfs(i + 1, j + 1)
//                } else {
//                    -1
//                }
//            } else if (j - 1 >= 0 && grid[i][j - 1] == -1) {
//                dfs(i + 1, j - 1)
//            } else {
//                -1
//            }.also {
//                seen[key] = it
//            }
//        }
//        for (i in 0 until n) {
//            ans.add(dfs(0, i))
//        }
//        return ans.toIntArray()
//    }
}