package leetcode.normal

import java.util.*

class Solution946 {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        var pop = 0
        val stack = Stack<Int>()
        pushed.forEach {
            stack.push(it)
            while (stack.isNotEmpty() && stack.peek() == popped[pop]) {
                println(stack.peek())
                stack.pop()
                pop++
            }
        }
        return stack.isEmpty()
    }
}