package leetcode.contest.last.c185

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5388()
    s.reformat("covid2019").print()
}

class Solution5388 {
    fun reformat(s: String): String {
        val map = s.groupBy { it in '0'..'9' }
        val n = map[true]?.size ?: 0
        val m = map[false]?.size ?: 0
        val ans = StringBuilder()
        if (n > m + 1 || m > n + 1) return ""
        val max = maxOf(n, m)
        for (i in 0 until max) {
            ans.append((map[n >= m]?.getOrNull(i) ?: ""))
            ans.append((map[n < m]?.getOrNull(i) ?: ""))
        }
        return ans.toString()
    }
}