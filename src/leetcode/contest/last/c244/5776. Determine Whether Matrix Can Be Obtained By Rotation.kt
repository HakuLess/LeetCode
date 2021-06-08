package leetcode.contest.last.c244

import leetcode.contest.utils.print
import leetcode.contest.utils.rotate
import leetcode.contest.utils.toGrid
import leetcode.contest.utils.toMatrix

fun main(args: Array<String>) {
    val s = Solution5776()
    s.findRotation("[[0,0,0],[0,1,0],[1,1,1]]".toGrid(), "[[1,1,1],[0,1,0],[0,0,0]]".toGrid()).print()
}

class Solution5776 {
    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val matrix = mat.toMatrix()
        for (c in 0 until 4) {
            matrix.rotate()
            if (matrix == target.toMatrix()) {
                return true
            }
        }
        return false
    }
}