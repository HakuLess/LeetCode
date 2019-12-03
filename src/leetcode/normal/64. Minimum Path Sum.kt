package leetcode.normal

class Solution64 {
    fun minPathSum(grid: Array<IntArray>): Int {
        val dp = Array(grid.size) { IntArray(grid[0].size) }
        for (i in grid.indices.reversed()) {
            for (j in grid[0].indices.reversed()) {
                if (i == grid.lastIndex && j != grid[0].lastIndex)
                    dp[i][j] = grid[i][j] + dp[i][j + 1]
                else if (j == grid[0].lastIndex && i != grid.lastIndex)
                    dp[i][j] = grid[i][j] + dp[i + 1][j]
                else if (j != grid[0].lastIndex && i != grid.lastIndex)
                    dp[i][j] = grid[i][j] + minOf(dp[i + 1][j], dp[i][j + 1])
                else dp[i][j] = grid[i][j]
            }
        }
        return dp[0][0]
    }

//    fun minPathSum(grid: Array<IntArray>): Int {
//        if (grid.isEmpty() || grid[0].isEmpty()) {
//            return 0
//        }
//        val dp = Array(grid.size) { IntArray(grid[0].size) }
//        var sum = 0
//        for (i in dp.indices) {
//            sum += grid[i][0]
//            dp[i][0] = sum
//        }
//        sum = 0
//        for (i in dp[0].indices) {
//            sum += grid[0][i]
//            dp[0][i] = sum
//        }
//        for (i in 1 until dp.size) {
//            for (j in 1 until dp[0].size) {
//                dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
//            }
//        }
//        return dp[dp.lastIndex][dp[0].lastIndex]
//    }
}