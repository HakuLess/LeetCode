package leetcode.contest.c134

class Solution1034 {
    val arrived = hashSetOf<Pair<Int, Int>>()
    val colorSet = hashSetOf<Pair<Int, Int>>()
    fun colorBorder(grid: Array<IntArray>, r0: Int, c0: Int, color: Int): Array<IntArray> {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return emptyArray()
        }

        val x = grid.size
        val y = grid[0].size
        val bColor = grid[r0][c0]

        arrived.add(Pair(r0, c0))
        colorSet.add(Pair(r0, c0))
        color(grid, bColor, color, r0 - 1, c0)
        color(grid, bColor, color, r0 + 1, c0)
        color(grid, bColor, color, r0, c0 - 1)
        color(grid, bColor, color, r0, c0 + 1)

        colorSet.forEach {
            if (it.first in 1..x - 2 && it.second in 1..y - 2) {
                if (Pair(it.first - 1, it.second) in colorSet &&
                        Pair(it.first + 1, it.second) in colorSet &&
                        Pair(it.first, it.second - 1) in colorSet &&
                        Pair(it.first, it.second + 1) in colorSet
                ) {

                } else {
                    grid[it.first][it.second] = color
                }
            } else {
                grid[it.first][it.second] = color
            }
        }
        return grid
    }

    private fun color(grid: Array<IntArray>, bColor: Int, color: Int, x: Int, y: Int) {
        if (Pair(x, y) in arrived) {
            return
        }
        if (x < 0 || x >= grid.size || y < 0 || y >= grid[0].size) {
            return
        }

        arrived.add(Pair(x, y))
        if (grid[x][y] == bColor) {
//            grid[x][y] = color
            colorSet.add(Pair(x, y))
            color(grid, bColor, color, x + 1, y)
            color(grid, bColor, color, x - 1, y)
            color(grid, bColor, color, x, y + 1)
            color(grid, bColor, color, x, y - 1)
        }
    }
}