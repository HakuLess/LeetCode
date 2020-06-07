package leetcode.normal

import java.util.*

class Solution20 {
    fun isValid(s: String): Boolean {
        val left = mapOf('(' to 0, '[' to 1, '{' to 2)
        val right = mapOf(')' to 0, ']' to 1, '}' to 2)
        val stack = Stack<Char>()
        s.forEach {
            when {
                it in left.keys -> stack.push(it)
                stack.isEmpty() -> return false
                right[it] == left[stack.peek()] -> stack.pop()
                else -> return false
            }
        }
        return stack.isEmpty()
    }
}