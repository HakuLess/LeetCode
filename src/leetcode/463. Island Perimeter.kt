package leetcode

fun islandPerimeter(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) {
        return 0
    }

    var perimeter = 0
    for (i in 0 until grid.size) {
        for (j in 0 until grid[0].size) {
            if (grid[i][j] == 1) {
                if (i == 0 || grid[i - 1][j] == 0) {
                    perimeter++
                }
                if (i == grid.size - 1 || grid[i + 1][j] == 0) {
                    perimeter++
                }
                if (j == 0 || grid[i][j - 1] == 0) {
                    perimeter++
                }
                if (j == grid[0].size - 1 || grid[i][j + 1] == 0) {
                    perimeter++
                }
            }
        }
    }
    return perimeter
}