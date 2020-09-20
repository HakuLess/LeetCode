package leetcode.contest.cur.leetcode.c207

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5521()
    s.maxProductPath(
            arrayOf(
                    intArrayOf(-1, -2, -3),
                    intArrayOf(-2, -3, -3),
                    intArrayOf(-3, -3, -2)
            )
    ).print()

    s.maxProductPath(
            arrayOf(
                    intArrayOf(-1, -4, 2),
                    intArrayOf(4, 3, -1),
                    intArrayOf(2, -4, 4),
                    intArrayOf(1, -1, -4)
            )
    ).print()
}

class Solution5521 {
    fun maxProductPath(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        val mod = (1e9 + 7).toLong()

        val seen = HashMap<String, Pair<Long, Long>>()
        fun dfs(x: Int, y: Int): Pair<Long, Long>? {
            if ("$x,$y" in seen.keys) {
                return seen["$x,$y"]
            }
            if (x == n - 1 && y == m - 1) return Pair(grid[x][y].toLong(), grid[x][y].toLong())
            if (x !in grid.indices || y !in grid[0].indices) return null
            val (a0, b0) = dfs(x + 1, y) ?: Pair(null, null)
            val (a1, b1) = dfs(x, y + 1) ?: Pair(null, null)

            var min = Long.MAX_VALUE / 2
            var max = Long.MIN_VALUE / 2

            val cur = grid[x][y]
            if (a0 != null) min = minOf(min, a0 * cur)
            if (a1 != null) min = minOf(min, a1 * cur)
            if (b0 != null) min = minOf(min, b0 * cur)
            if (b1 != null) min = minOf(min, b1 * cur)

            if (a0 != null) max = maxOf(max, a0 * cur)
            if (a1 != null) max = maxOf(max, a1 * cur)
            if (b0 != null) max = maxOf(max, b0 * cur)
            if (b1 != null) max = maxOf(max, b1 * cur)
            return Pair(min, max).also {
                seen["$x,$y"] = it
            }
        }
        val ans = (dfs(0, 0)!!.toList().max()!! % mod).toInt()
        if (ans < 0) return -1
        return ans
    }
}