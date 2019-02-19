package leetcode

import java.util.*

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach {
        if (stack.isEmpty()) {
            stack.push(it)
        } else {
            if (stack.peek() == '(' && it == ')') {
                stack.pop()
            } else if (stack.peek() == '{' && it == '}') {
                stack.pop()
            } else if (stack.peek() == '[' && it == ']') {
                stack.pop()
            } else {
                stack.push(it)
            }
        }
    }

    return stack.isEmpty()
}