package leetcode.contest.last.c134

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1033()
    s.numMovesStones(1, 2, 5).print()
    s.numMovesStones(4, 3, 2).print()
}

class Solution1033 {
    fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
        val (x, y, z) = intArrayOf(a, b, c).sorted()
        return if (z - x == 2) {
            intArrayOf(0, 0)
        } else if (y - x <= 2 || z - y <= 2)
            intArrayOf(1, z - x - 2)
        else
            intArrayOf(2, z - x - 2)
    }
}