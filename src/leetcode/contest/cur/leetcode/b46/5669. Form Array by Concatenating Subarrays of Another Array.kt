package leetcode.contest.cur.leetcode.b46

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5669()
    s.canChoose("[[1,-1,-1],[3,-2,0]]".toGrid(), intArrayOf(1, -1, 0, 1, -1, -1, 3, -2, 0)).print()
    s.canChoose("[[1,2,3],[3,4]]".toGrid(), intArrayOf(7, 7, 1, 2, 3, 4, 7, 7)).print()
}

class Solution5669 {
    fun canChoose(groups: Array<IntArray>, nums: IntArray): Boolean {
        var cur = nums.joinToString(",")
        groups.forEach {
            val next = cur.indexOf(it.joinToString(","))
            if (next == -1) return false
            cur = cur.substring(next + it.joinToString(",").length)
        }
        return true
    }
}