package leetcode

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    if (obstacleGrid.isEmpty() || obstacleGrid[0].isEmpty()) {
        return 0
    }

    if (obstacleGrid.size == 1) {
        return if (obstacleGrid[0].max()!! > 0) {
            0
        } else {
            1
        }
    }

    val x = obstacleGrid.size
    val y = obstacleGrid[0].size
    val dp = Array(x) { IntArray(y) }

    for (i in 0 until x) {
        for (j in 0 until y) {
            dp[i][j] = when {
                obstacleGrid[i][j] == 1 -> 0
                i == 0 && j == 0 -> 1 - obstacleGrid[0][0]
                i == 0 -> dp[i][j - 1]
                j == 0 -> dp[i - 1][j]
                else -> dp[i - 1][j] + dp[i][j - 1]
            }
        }
    }

    return dp[x - 1][y - 1]
}