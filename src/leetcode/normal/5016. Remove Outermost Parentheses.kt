package leetcode.normal

import leetcode.print
import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5016()
    s.removeOuterParentheses("(()())(())").print()
    s.removeOuterParentheses("(()())(())(()(()))").print()
    s.removeOuterParentheses("()()").print()
}

class Solution5016 {
    fun removeOuterParentheses(S: String): String {

        val ans = StringBuilder()
        val stack = Stack<Char>()
        S.forEach {
            if (stack.isEmpty()) {
                stack.add(it)
            } else {
                val item = stack.peek()
                stack.add(it)
                if (stack.peek() == ')' && item == '(') {
                    stack.pop()
                    stack.pop()
                }
                if (stack.isNotEmpty()) {
                    ans.append(it)
                }
            }

        }
        return ans.toString()
    }
}