package leetcode.contest.cur.b12

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5096()
    s.transformArray(intArrayOf(6, 2, 3, 4)).toString().print()
    s.transformArray(intArrayOf(1, 6, 3, 4, 3, 5)).toString().print()
}

class Solution5096 {
    fun transformArray(arr: IntArray): List<Int> {
        var cur = arr
        val next = arr.clone()
        do {
            cur = next.clone()
            for (i in 1 until arr.lastIndex) {
                if (cur[i] > cur[i - 1] && cur[i] > cur[i + 1]) {
                    next[i] = cur[i] - 1
                }
                if (cur[i] < cur[i - 1] && cur[i] < cur[i + 1]) {
                    next[i] = cur[i] + 1
                }
            }
        } while (next.joinToString(",") != cur.joinToString(","))

        return next.toList()
    }
}
