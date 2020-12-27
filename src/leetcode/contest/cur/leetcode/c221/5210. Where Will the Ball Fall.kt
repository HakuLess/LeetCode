package leetcode.contest.cur.leetcode.c221

class Solution5210 {
    fun findBall(grid: Array<IntArray>): IntArray {
        val ans = arrayListOf<Int>()
        val m = grid.size
        val n = grid[0].size
        val seen = HashMap<String, Int>()
        fun dfs(row: Int, col: Int): Int {
            val key = "$row,$col"
            if (key in seen) {
                return seen[key]!!
            }
            if (row >= m)
                return col
            return if (grid[row][col] == 1) {
                if (col + 1 < n && grid[row][col + 1] == 1) {
                    dfs(row + 1, col + 1)
                } else {
                    -1
                }
            } else if (col - 1 >= 0 && grid[row][col - 1] == -1) {
                dfs(row + 1, col - 1)
            } else {
                -1
            }.also {
                seen[key] = it
            }
        }
        for (i in 0 until n) {
            ans.add(dfs(0, i))
        }
        return ans.toIntArray()
    }
}