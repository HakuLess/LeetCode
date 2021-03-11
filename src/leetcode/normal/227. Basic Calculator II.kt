package leetcode.normal

import java.util.*


class Solution227 {
    fun calculate(s: String): Int {
        val stack = Stack<Int>()
        var preSign = '+'
        var num = 0
        val n: Int = s.length
        for (i in 0 until n) {
            if (s[i] in '0'..'9') {
                num = num * 10 + (s[i] - '0')
            }
            if (s[i] !in '0'..'9' && s[i] != ' ' || i == n - 1) {
                when (preSign) {
                    '+' -> stack.push(num)
                    '-' -> stack.push(-num)
                    '*' -> stack.push(stack.pop() * num)
                    else -> stack.push(stack.pop() / num)
                }
                preSign = s[i]
                num = 0
            }
        }
        var ans = 0
        while (!stack.isEmpty()) {
            ans += stack.pop()
        }
        return ans
    }
}