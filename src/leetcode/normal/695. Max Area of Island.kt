package leetcode.normal

class Solution695 {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val dirs = arrayListOf(Pair(0, 1), Pair(-1, 0), Pair(0, -1), Pair(1, 0))
        val n = grid.size
        val m = grid[0].size

        fun dfs(i: Int, j: Int): Int {
            if (i !in 0 until n ||
                    j !in 0 until m ||
                    grid[i][j] != 1)
                return 0
            var ans = 1
            grid[i][j] = 0
            for (k in 0..3) {
                ans += dfs(dirs[k].first + i, dirs[k].second + j)
            }
            return ans
        }

        var ans = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                ans = maxOf(ans, dfs(i,j))
            }
        }
        return ans
    }
}