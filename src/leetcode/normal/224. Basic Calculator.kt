package leetcode.normal

import java.util.*


class Solution224 {
    fun calculate(s: String): Int {
        val ops = Stack<Int>()
        ops.push(1)
        var sign = 1

        var ans = 0
        val n: Int = s.length
        var i = 0
        while (i < n) {
            when {
                s[i] == ' ' -> {
                    i++
                }
                s[i] == '+' -> {
                    sign = ops.peek()
                    i++
                }
                s[i] == '-' -> {
                    sign = -ops.peek()
                    i++
                }
                s[i] == '(' -> {
                    ops.push(sign)
                    i++
                }
                s[i] == ')' -> {
                    ops.pop()
                    i++
                }
                else -> {
                    var num: Long = 0
                    while (i < n && s[i] in '0'..'9') {
                        num = num * 10 + (s[i] - '0')
                        i++
                    }
                    ans += sign * num.toInt()
                }
            }
        }
        return ans
    }
}