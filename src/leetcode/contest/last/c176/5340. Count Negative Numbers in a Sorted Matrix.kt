package leetcode.contest.last.c176

import leetcode.contest.utils.count
import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import leetcode.contest.utils.toMatrix

fun main(args: Array<String>) {
    val s = Solution5340()
    s.countNegatives("[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]".toGrid()).print()
}

class Solution5340 {
    fun countNegatives(grid: Array<IntArray>): Int {
        return grid.toMatrix().count {
            it < 0
        }
    }
}