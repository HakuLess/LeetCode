package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val a = Solution856()
//    a.scoreOfParentheses("(())").print()
//    a.scoreOfParentheses("(()(()))").print()
//    a.scoreOfParentheses("()()()").print()
//    a.scoreOfParentheses("()(())").print()
    a.scoreOfParentheses("(()(()))").print()
}

class Solution856 {
    fun scoreOfParentheses(S: String): Int {
        val stack = Stack<Char>()
        var ans = 0
        for (i in 0 until S.length) {
            if (stack.isEmpty()) {
                stack.push(S[i])
            } else {
                if (S[i] == ')' && stack.peek() == '(') {
                    stack.pop()
                    if (S[i] == ')' && S[i - 1] == '(') {
                        ans += Math.pow(2.0, stack.size.toDouble()).toInt()
                    }
                } else {
                    stack.push(S[i])
                }
            }
        }

        return ans
    }
}