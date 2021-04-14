package leetcode.normal

class Solution883 {
    fun projectionArea(grid: Array<IntArray>): Int {
        val n = grid.size
        var ans = 0

        for (i in 0 until n) {
            var bestRow = 0
            var bestCol = 0
            for (j in 0 until n) {
                if (grid[i][j] > 0) ans++
                bestRow = maxOf(bestRow, grid[i][j])
                bestCol = maxOf(bestCol, grid[j][i])
            }
            ans += bestRow + bestCol
        }

        return ans
    }
}