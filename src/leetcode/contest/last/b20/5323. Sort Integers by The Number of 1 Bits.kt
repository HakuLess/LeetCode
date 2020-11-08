package leetcode.contest.last.b20

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5323()
    s.sortByBits(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)).print()
    s.sortByBits(intArrayOf(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1)).print()
}

class Solution5323 {
    fun sortByBits(arr: IntArray): IntArray {
        return arr.sortedWith(compareBy({ Integer.bitCount(it) }, { it })).toIntArray()
    }
}