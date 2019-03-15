package leetcode

import java.util.*

class Solution696 {
    fun countBinarySubstrings(s: String): Int {
        val stack0 = Stack<Char>()
        val stack1 = Stack<Char>()
        var ans = 0
        var pre: Char? = null
        s.forEach {
            if (it == '0') {
                if (stack1.isNotEmpty()) {
                    stack1.pop()
                    ans++
                }
                if (pre == '1') {
                    stack0.clear()
                }
                stack0.push(it)
            } else if (it == '1') {
                if (stack0.isNotEmpty()) {
                    stack0.pop()
                    ans++
                }
                if (pre == '0') {
                    stack1.clear()
                }
                stack1.push(it)
            }
            pre = it
        }

        return ans
    }
}