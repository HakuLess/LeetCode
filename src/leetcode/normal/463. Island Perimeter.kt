package leetcode.normal

class Solution463 {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }
        var ans = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        ans++
                    }
                    if (i == grid.size - 1 || grid[i + 1][j] == 0) {
                        ans++
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        ans++
                    }
                    if (j == grid[0].size - 1 || grid[i][j + 1] == 0) {
                        ans++
                    }
                }
            }
        }
        return ans
    }
}