package leetcode

class Solution64 {
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }

        val dp = Array(grid.size) { IntArray(grid[0].size) }

        var sum = 0
        for (i in 0 until dp.size) {
            sum += grid[i][0]
            dp[i][0] = sum
        }

        sum = 0
        for (i in 0 until dp[0].size) {
            sum += grid[0][i]
            dp[0][i] = sum
        }

        for (i in 1 until dp.size) {
            for (j in 1 until dp[0].size) {
                dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
            }
        }

        return dp[dp.lastIndex][dp[0].lastIndex]
    }
}