package leetcode.contest.last.c238

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5741()
//    s.maxBuilding(5, "[[2,1],[4,1]]".toGrid()).print()
    s.maxBuilding(10, "[[5,3],[2,5],[7,4],[10,3]]".toGrid()).print()
}

class Solution5741 {
    fun maxBuilding(n: Int, restrictions: Array<IntArray>): Int {
        val m = restrictions.size
        if (m == 0)
            return n - 1
        restrictions.sortBy { it[0] }
        val l = IntArray(m)
        val r = IntArray(m)
        l[0] = minOf(restrictions[0][1], restrictions[0][0] - 1)
        for (i in 1 until m) {
            val left = l[i - 1]
            val dist = restrictions[i][0] - restrictions[i - 1][0]
            l[i] = minOf(restrictions[i][1], left + dist)
        }
        r[m - 1] = restrictions[m - 1][1]
        for (i in m - 2 downTo 0) {
            val right = r[i + 1]
            val dist = restrictions[i + 1][0] - restrictions[i][0]
            r[i] = minOf(restrictions[i][1], right + dist)
        }
        var ans = 0
        for (i in 0 until m - 1) {
            val lh = minOf(l[i], r[i])
            val rh = minOf(l[i + 1], r[i + 1])
            val dist = restrictions[i + 1][0] - restrictions[i][0]
            ans = maxOf(ans, (lh + rh + dist) / 2)
        }
        ans = maxOf(ans, n - restrictions[m - 1][0] + minOf(l[m - 1], r[m - 1]))
        return ans
    }
}