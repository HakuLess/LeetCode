package leetcode.normal

import leetcode.contest.utils.print
import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) {
    val s = Solution394()
    s.decodeString("3[a2[c]]").print()
    s.decodeString("2[abc]3[cd]ef").print()
}

class Solution394 {
    fun decodeString(s: String): String {
        val stack = Stack<String>()
        var num = ""
        s.forEach {
            if (num.isNotEmpty() && it !in '0'..'9') {
                stack.push(num)
                num = ""
            }

            if (it != ']' && it !in '0'..'9') {
                stack.push(it.toString())
            } else if (it in '0'..'9') {
                num += it
            } else {
                val str = StringBuilder()
                val tempStack = Stack<String>()
                while (stack.peek() != "[") {
                    tempStack.push(stack.pop())
                }
                stack.pop()
                val times = stack.pop().toInt()
                while (tempStack.isNotEmpty()) {
                    str.append(tempStack.pop())
                }
                val result = StringBuilder()
                for (i in 0 until times) {
                    result.append(str)
                }
                stack.push(result.toString())
            }
        }

        return stack.joinToString("")
    }
}