package leetcode

import kotlin.math.max

fun projectionArea(grid: Array<IntArray>): Int {
    var ans = 0

    var maxY = 0
    var maxZ = 0
    grid.forEach {
        ans += it.filter { it != 0 }.size

        maxY = max(maxY, it.size)
        maxZ += it.max()!!
    }

    ans += maxZ

    for (i in 0 until maxY) {
        var max = 0
        grid.forEach {
            max = max(max, it.getOrElse(i) { 0 })
        }
        ans += max
    }

    return ans
}