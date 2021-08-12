package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution329()
    s.longestIncreasingPath(
            arrayOf(
                    intArrayOf(9, 9, 4),
                    intArrayOf(6, 6, 8),
                    intArrayOf(2, 2, 1)
            )
    ).print()
}

class Solution329 {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val seen = HashMap<Triple<Int, Int, Int>, Int>()
        var ans = 0
        fun dfs(x: Int, y: Int, cur: Int): Int {
            if (Triple(x, y, cur) in seen) {
                return seen[Triple(x, y, cur)]!!
            }
            if (x !in matrix.indices || y !in matrix[0].indices) return 0
            if (matrix[x][y] <= cur) return 0
            return (1 + intArrayOf(
                    dfs(x + 1, y, matrix[x][y]),
                    dfs(x - 1, y, matrix[x][y]),
                    dfs(x, y + 1, matrix[x][y]),
                    dfs(x, y - 1, matrix[x][y])
            ).maxOrNull()!!).also {
                seen[Triple(x, y, cur)] = it
//                println("set $x, $y with $it")
                ans = maxOf(ans, it)
            }
        }

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                dfs(i, j, -1)
            }
        }
        return ans
    }
}