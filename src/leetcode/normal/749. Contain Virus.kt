package leetcode.normal

import leetcode.print

// todo not finish, Simulation is not interesting
fun main(args: Array<String>) {
    val s = Solution749()
    s.containVirus(
            arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 1)
            )
    ).print()
}

class Solution749 {
    fun containVirus(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }

        val n = grid.size
        val m = grid[0].size

        val matrix = Array(2 * n - 1) { IntArray(2 * m - 1) { -1 } }
        for (i in 0 until n) {
            for (j in 0 until m) {
                matrix[i * 2][j * 2] = grid[i][j]
            }
        }

        matrix.print()
        val visited = hashSetOf<Pair<Int, Int>>()
        for (i in 0 until n) {
            for (j in 0 until m) {
                print("$i, $j : ")
                dfs(i * 2, j * 2, matrix, visited, i * 2, j * 2).print()
            }
        }

        return 0
    }

    private fun dfs(i: Int, j: Int, matrix: Array<IntArray>, hashSet: HashSet<Pair<Int, Int>>,
                    preI: Int, preJ: Int): Int {
        if (Pair(i, j) in hashSet) {
            return 0
        }

        if (i < 0 || i > matrix.lastIndex || j < 0 || j > matrix[0].lastIndex) {
            return 0
        }

        var count = 0
        if (matrix[i][j] == 1) {
            hashSet.add(Pair(i, j))
            count += dfs(i - 2, j, matrix, hashSet, i, j)
            count += dfs(i + 2, j, matrix, hashSet, i, j)
            count += dfs(i, j - 2, matrix, hashSet, i, j)
            count += dfs(i, j + 2, matrix, hashSet, i, j)
        } else {
            if (matrix[(i + preI) / 2][(j + preJ) / 2] == -1) {
                count++
            }
        }
        return count
    }
}