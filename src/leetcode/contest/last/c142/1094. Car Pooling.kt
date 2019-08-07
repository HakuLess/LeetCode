package leetcode.contest.last.c142

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val a = Solution1094()
    a.carPooling(arrayOf(
            intArrayOf(2, 1, 5),
            intArrayOf(3, 3, 7)
    ), 4).print()
}

class Solution1094 {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val up = trips.clone()
        val down = trips.clone()
        up.sortBy { it[1] }
        down.sortBy { it[2] }

        var upIndex = 0
        var downIndex = 0
        var cur = 0
        for (i in 0 until 1001) {
            while (upIndex <= up.lastIndex && i == up[upIndex][1]) {
                cur += up[upIndex][0]
                upIndex++
            }
            while (downIndex <= down.lastIndex && i == down[downIndex][2]) {
                cur -= down[downIndex][0]
                downIndex++
            }

            if (cur > capacity) {
                return false
            }
        }
        return true
    }
}