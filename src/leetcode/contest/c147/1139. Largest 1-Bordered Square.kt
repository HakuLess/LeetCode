package leetcode.contest.c147

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1139()
    s.largest1BorderedSquare(
            arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 1)
            )
    ).print()

    s.largest1BorderedSquare(
            arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 0)
            )
    ).print()
}

class Solution1139 {
    fun largest1BorderedSquare(grid: Array<IntArray>): Int {
        var ans = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                ans = maxOf(ans, getMax(i, j, grid))
            }
        }
        return ans
    }

    private fun getMax(x: Int, y: Int, grid: Array<IntArray>): Int {
        var size = 0
        var max = 0
        while (x + size < grid.size && y + size < grid[0].size && grid[x + size][y] == 1 && grid[x][y + size] == 1) {

            var sq = true
            for (i in 0..size) {
                if (grid[x + size][y + i] != 1) {
                    sq = false
                    break
                }
            }
            for (i in 0..size) {
                if (grid[x + i][y + size] != 1) {
                    sq = false
                    break
                }
            }

            if (sq) {
                max = (size + 1) * (size + 1)
                println("$x, $y, $size, $sq : $max")
            }
            size++
        }
        return max
    }
}