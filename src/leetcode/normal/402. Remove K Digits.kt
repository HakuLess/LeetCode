package leetcode.normal

import java.util.*

class Solution402 {
    fun removeKdigits(num: String, k: Int): String {
        var l = k
        val st = Stack<Int>()
        num.forEach {
            val c = it - '0'
            while (st.isNotEmpty() && c < st.peek() && l != 0) {
                st.pop()
                l--
            }
            st.push(it - '0')
        }
        while (l != 0) {
            st.pop()
            l--
        }
        return st.joinToString("").trimStart('0').let {
            if (it.isEmpty()) "0"
            else it
        }
    }
}