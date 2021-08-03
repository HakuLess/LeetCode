package leetcode.contest.cur.leetcode.c251

import leetcode.contest.utils.permute
import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5825()
    s.maxCompatibilitySum("[[1,1,0],[1,0,1],[0,0,1]]".toGrid(), "[[1,0,0],[0,0,1],[1,1,0]]".toGrid()).print()
}

class Solution5825 {
    fun maxCompatibilitySum(students: Array<IntArray>, mentors: Array<IntArray>): Int {
        var res = 0
        val source = IntArray(students.size) { i -> i }
        source.permute().forEach {
            var tmp = 0
            for (i in it.indices) {
                for (j in students[0].indices) {
                    if (students[i][j] == mentors[it[i]][j]) {
                        tmp++
                    }
                }
            }
            res = maxOf(res, tmp)
        }
        return res
    }
}

