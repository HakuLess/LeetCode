package leetcode.normal

import java.util.*

class Solution921 {
    fun minAddToMakeValid(S: String): Int {
        val stack = Stack<Char>()
        S.forEach {
            if (stack.isEmpty()) {
                stack.push(it)
            } else {
                if (it == ')' && stack.peek() == '(') {
                    stack.pop()
                } else {
                    stack.push(it)
                }
            }
        }
        return stack.size
    }
}