package leetcode.contest.cur.leetcode.c216

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5608()
    s.minimumEffort(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(4, 8)
    )).print()

    s.minimumEffort(arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(10, 11),
            intArrayOf(10, 12),
            intArrayOf(8, 9)
    )).print()

    s.minimumEffort(arrayOf(
            intArrayOf(1, 7),
            intArrayOf(2, 8),
            intArrayOf(3, 9),
            intArrayOf(4, 10),
            intArrayOf(5, 11),
            intArrayOf(6, 12)
    )).print()
}

class Solution5608 {
    fun minimumEffort(tasks: Array<IntArray>): Int {
        val st = tasks.sortedBy { it[0] - it[1] }
        var cur = 0
        var ans = 0
        for (i in st.indices) {
            if (st[i][1] > cur) {
                ans += st[i][1] - cur
                cur += st[i][1] - cur
            }
            cur -= st[i][0]
        }
        return ans
    }
}