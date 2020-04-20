package leetcode.normal

class Solution200 {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }
        var ans = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '1') {
                    ans--
                    dfs(grid, i, j, ans)
                }
            }
        }
        return -ans
    }

    fun dfs(grid: Array<CharArray>, x: Int, y: Int, ans: Int) {
        grid[x][y] = ans.toChar()
        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            grid[x - 1][y] = ans.toChar()
            dfs(grid, x - 1, y, ans)
        }
        if (x + 1 < grid.size && grid[x + 1][y] == '1') {
            grid[x + 1][y] = ans.toChar()
            dfs(grid, x + 1, y, ans)
        }
        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            grid[x][y - 1] = ans.toChar()
            dfs(grid, x, y - 1, ans)
        }
        if (y + 1 < grid[0].size && grid[x][y + 1] == '1') {
            grid[x][y + 1] = ans.toChar()
            dfs(grid, x, y + 1, ans)
        }
    }
}