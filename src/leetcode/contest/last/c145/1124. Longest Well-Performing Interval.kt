package leetcode.contest.last.c145

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1124()
    s.longestWPI(
            intArrayOf(9, 9, 6, 0, 6, 6, 9)
    ).print()
}

class Solution1124 {
    fun longestWPI(hours: IntArray): Int {
        val h = hours.map {
            if (it > 8) {
                1
            } else {
                -1
            }
        }

        var ans = 0
        for (i in 0 until hours.size) {
            var all = 0
            var cur = -1
            for (j in i until hours.size) {
                all += h[j]
                if (all > 0) {
                    cur = j
                }
            }
            ans = maxOf(ans, cur - i + 1)
        }
        return ans
    }
}