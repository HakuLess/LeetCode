package leetcode.contest.cur.leetcode.b33

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5482()
    s.containsCycle(arrayOf(
            charArrayOf('a', 'a', 'a', 'a'),
            charArrayOf('a', 'b', 'b', 'a'),
            charArrayOf('a', 'b', 'b', 'a'),
            charArrayOf('a', 'a', 'a', 'a')
    )).print()

    s.containsCycle(arrayOf(
            charArrayOf('a', 'a', 'b')
    )).print()
}


class Solution5482 {
    fun containsCycle(grid: Array<CharArray>): Boolean {

        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, 1, 0, -1)

        val visited = Array(grid.size) { BooleanArray(grid[0].size) { false } }
        val n = grid.size
        val m = grid[0].size
        var cycle = false

        fun isValid(x: Int, y: Int): Boolean {
            return x in 0 until n && y < m && y >= 0
        }

        fun isCycle(x: Int, y: Int, arr: Array<CharArray>,
                    visited: Array<BooleanArray>,
                    parentX: Int, parentY: Int): Boolean {
            visited[x][y] = true
            for (k in 0..3) {
                val newX = x + dx[k]
                val newY = y + dy[k]
                if (isValid(newX, newY) && arr[newX][newY] == arr[x][y] && !(parentX == newX && parentY == newY)) {
                    if (visited[newX][newY]) {
                        return true
                    } else {
                        val check = isCycle(newX, newY, arr, visited, x, y)
                        if (check) return true
                    }
                }
            }
            return false
        }

        for (i in 0 until n) {
            if (cycle) return true
            for (j in 0 until m) {
                if (!visited[i][j]) {
                    cycle = isCycle(i, j, grid, visited, -1, -1)
                }
                if (cycle) return true
            }
        }
        return false
    }
}