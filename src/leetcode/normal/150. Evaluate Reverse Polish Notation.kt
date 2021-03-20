package leetcode.normal

import java.util.*

class Solution150 {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        tokens.forEach {
            when (it) {
                "+" -> {
                    stack.push(stack.pop() + stack.pop())
                }
                "-" -> {
                    val data1 = stack.pop()
                    val data2 = stack.pop()
                    stack.push(data2 - data1)
                }
                "*" -> {
                    stack.push(stack.pop() * stack.pop())
                }
                "/" -> {
                    val data1 = stack.pop()
                    val data2 = stack.pop()
                    stack.push(data2 / data1)
                }
                else -> {
                    stack.push(it.toInt())
                }
            }
        }
        return stack.peek()
    }
}