package leetcode.contest.cur.leetcode.c210

import java.util.*

class Solution5535 {
    fun maxDepth(s: String): Int {
        var ans = 0
        val st = Stack<Char>()
        s.forEach { c ->
            when (c) {
                '(' -> st.add(c)
                ')' -> st.pop()
            }
            ans = maxOf(ans, st.size)
        }
        return ans
    }
}