package leetcode.contest.last.c161

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5249()
    s.minRemoveToMakeValid("lee(t(c)o)de)").print()
    s.minRemoveToMakeValid("a)b(c)d").print()
    s.minRemoveToMakeValid("))((").print()
    s.minRemoveToMakeValid("(a(b(c)d)").print()
    s.minRemoveToMakeValid("())()(((").print()
}

class Solution5249 {
    fun minRemoveToMakeValid(s: String): String {
        val stack = Stack<Pair<Int, Char>>()
        s.forEachIndexed { index, it ->
            if (it == '(') {
                stack.push(Pair(index, '('))
            } else if (it == ')') {
                if (stack.isNotEmpty() && stack.peek().second == '(') {
                    stack.pop()
                } else {
                    stack.push(Pair(index, ')'))
                }
            }
        }

        var ans = ""
        var index = 0
        s.forEachIndexed { ind, c ->
            if (index <= stack.lastIndex && ind == stack[index].first) {
                index++
            } else {
                ans += c
            }
        }
        return ans
    }
}