package leetcode.normal

import java.lang.StringBuilder
import java.util.*

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
            val times = Integer.parseInt(stack.pop())
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

    var res = ""
    stack.forEach {
        res += it
    }
    return res
}