package leetcode.contest.last.c137

import leetcode.print
import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1047()
    s.removeDuplicates("abbaca").print()
}

class Solution1047 {
    fun removeDuplicates(S: String): String {
        val stack = Stack<Char>()
        S.forEach {
            if (stack.isEmpty()) {
                stack.push(it)
            } else {
                if (stack.peek() == it) {
                    stack.pop()
                } else {
                    stack.push(it)
                }
            }
        }

        val result = StringBuilder()
        while (stack.isNotEmpty()) {
            result.append(stack.pop())
        }
        return result.toString().reversed()
    }
}