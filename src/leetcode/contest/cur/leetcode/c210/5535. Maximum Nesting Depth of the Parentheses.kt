package leetcode.contest.cur.leetcode.c210

import java.util.*

class Solution5535 {
    fun maxDepth(s: String): Int {
        var ans = 0
        val st = Stack<Char>()
        for (c in s) {
            when(c) {
                '(' -> {
                    st.add(c)
                }
                ')' -> {
                    st.pop()
                }
                else -> {
                    ans = maxOf(ans, st.size)
                }
            }
        }
        return ans
    }
}