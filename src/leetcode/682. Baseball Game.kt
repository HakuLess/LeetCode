package leetcode

import java.util.*

class Solution682 {
    fun calPoints(ops: Array<String>): Int {
        val stack = Stack<Int>()
        var ans = 0
        ops.forEach {
            println(ans)
            when (it) {
                "C" -> {
                    val item = stack.pop()
                    ans -= item
                }
                "D" -> {
                    val item = stack.peek() * 2
                    stack.push(item)
                    ans += item
                }
                "+" -> {
                    val item = stack.pop()
                    var score = stack.peek()
                    stack.push(item)
                    score += stack.peek()
                    stack.push(score)
                    ans += score
                }
                else -> {
                    val item = Integer.parseInt(it)
                    stack.push(item)
                    ans += item
                }
            }
        }
        return ans
    }
}