package leetcode.normal

class Solution959 {
    fun regionsBySlashes(grid: Array<String>): Int {
        if (grid.isEmpty()) {
            return 0
        }
        val n = grid.size
        val matrix = Array(n * 3) { IntArray(n * 3) }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (grid[i][j] == '\\') {
                    matrix[i * 3][j * 3] = 1
                    matrix[i * 3 + 1][j * 3 + 1] = 1
                    matrix[i * 3 + 2][j * 3 + 2] = 1
                } else if (grid[i][j] == '/') {
                    matrix[i * 3 + 2][j * 3] = 1
                    matrix[i * 3 + 1][j * 3 + 1] = 1
                    matrix[i * 3][j * 3 + 2] = 1
                }
            }
        }

        var ans = 0
        for (i in 0 until 3 * n) {
            for (j in 0 until 3 * n) {
                if (matrix[i][j] == 0) {
                    visit(matrix, i, j, 3 * n)
                    ans++
                }
            }
        }
        return ans
    }

    private fun visit(matrix: Array<IntArray>, x: Int, y: Int, bound: Int) {
        if (x < 0 || x >= bound || y < 0 || y >= bound) {
            return
        }
        if (matrix[x][y] > 0) {
            return
        }
        matrix[x][y] = 1
        visit(matrix, x + 1, y, bound)
        visit(matrix, x - 1, y, bound)
        visit(matrix, x, y + 1, bound)
        visit(matrix, x, y - 1, bound)
    }
}