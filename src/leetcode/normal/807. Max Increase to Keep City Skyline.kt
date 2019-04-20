package leetcode.normal

import kotlin.math.max
import kotlin.math.min

fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) {
        return 0
    }
    val hor = IntArray(grid[0].size)
    val ver = IntArray(grid.size)

    for (i in 0 until hor.size) {
        for (j in 0 until ver.size) {
            ver[j] = grid[j].max()!!
            hor[i] = max(hor[i], grid[j][i])
        }
    }

    var ans = 0
    for (i in 0 until hor.size) {
        for (j in 0 until ver.size) {
            ans += min(ver[j], hor[i]) - grid[j][i]
        }
    }

    return ans
}