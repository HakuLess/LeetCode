package leetcode.contest.last.c137

import leetcode.contest.utils.print
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
            if (stack.isEmpty() || stack.peek() != it) {
                stack.push(it)
            } else {
                stack.pop()
            }
        }
        return stack.joinToString("")
    }
}