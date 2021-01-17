package leetcode.contest.last.c159

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5230()
    s.checkStraightLine(arrayOf(
            intArrayOf(-3, -2),
            intArrayOf(-1, -2),
            intArrayOf(2, -2),
            intArrayOf(-2, -2),
            intArrayOf(0, -2)
    )).print()
}

class Solution5230 {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        coordinates.sortBy { it[0] }
        val x = coordinates[1][0] - coordinates[0][0]
        val y = coordinates[1][1] - coordinates[0][1]
        for (i in 2 until coordinates.size) {
            if ((coordinates[i][0] - coordinates[0][0]) * y == (coordinates[i][1] - coordinates[0][1]) * x) {
                continue
            }
            return false
        }
        return true
    }
}