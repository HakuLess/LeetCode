package leetcode.contest.cur.leetcode.c201

import java.util.*

class Solution5483 {
    fun makeGood(s: String): String {
        val st = Stack<Char>()
        s.forEach {
            if (st.isNotEmpty() && (st.peek() != it &&
                        (st.peek().toUpperCase() == it || st.peek().toLowerCase() == it))
            ) {
                st.pop()
            } else {
                st.push(it)
            }
        }
        return st.joinToString("")
    }
}