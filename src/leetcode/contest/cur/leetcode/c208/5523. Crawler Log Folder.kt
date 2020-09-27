package leetcode.contest.cur.leetcode.c208

import java.util.*

class Solution5523 {
    fun minOperations(logs: Array<String>): Int {
        val st = Stack<String>()
        for (log in logs) {
            if (log == "../") {
                if (st.isNotEmpty()) {
                    st.pop()
                }
            } else if (log == "./") {
                continue
            } else {
                st.push(log)
            }
        }
        return st.size
    }
}