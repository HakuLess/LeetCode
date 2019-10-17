package leetcode.contest.last.c157

import leetcode.contest.utils.print
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5215()
    s.getMaximumGold(
            arrayOf(
                    intArrayOf(0, 6, 0),
                    intArrayOf(5, 8, 7),
                    intArrayOf(0, 9, 0)
            )
    ).print()
}

class Solution5215 {
    var max = 0
    fun getMaximumGold(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] != 0) {
                    dfs(hashSetOf(), Pair(i, j), 0, grid)
                }
            }
        }
        return max
    }

    private fun dfs(seen: HashSet<Pair<Int, Int>>, cur: Pair<Int, Int>, total: Int, grid: Array<IntArray>) {
        if (cur.first !in 0..grid.lastIndex || cur.second !in 0..grid[0].lastIndex || cur in seen) {
            return
        }
        if (grid[cur.first][cur.second] == 0) {
            return
        }

        max = maxOf(max, total + grid[cur.first][cur.second])
        println("$max: ${cur.first}, ${cur.second}")

        seen.add(cur)
        dfs(seen.clone() as HashSet<Pair<Int, Int>>, Pair(cur.first + 1, cur.second), total + grid[cur.first][cur.second], grid)
        dfs(seen.clone() as HashSet<Pair<Int, Int>>, Pair(cur.first - 1, cur.second), total + grid[cur.first][cur.second], grid)
        dfs(seen.clone() as HashSet<Pair<Int, Int>>, Pair(cur.first, cur.second + 1), total + grid[cur.first][cur.second], grid)
        dfs(seen.clone() as HashSet<Pair<Int, Int>>, Pair(cur.first, cur.second - 1), total + grid[cur.first][cur.second], grid)
    }
}