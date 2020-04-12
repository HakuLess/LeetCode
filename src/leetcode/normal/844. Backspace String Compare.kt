package leetcode.normal

import java.util.*

class Solution844 {
    fun backspaceCompare(S: String, T: String): Boolean {
        return helper(S) == helper(T)
    }

    private fun helper(str: String): String {
        val s = Stack<Char>()
        str.forEach {
            if (it == '#') {
                if (s.isNotEmpty()) {
                    s.pop()
                }
            } else {
                s.push(it)
            }
        }
        return s.joinToString("")
    }
}