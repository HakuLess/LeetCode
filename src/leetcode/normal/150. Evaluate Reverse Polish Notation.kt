package leetcode.normal

import java.util.*

fun evalRPN(tokens: Array<String>): Int {
    val stackData = Stack<Int>()
    var ans = 0

    tokens.forEach {
        if (it == "+" || it == "-" || it == "*" || it == "/") {
            when (it) {
                "+" -> {
                    ans = stackData.pop() + stackData.pop()
                }
                "-" -> {
                    val data1 = stackData.pop()
                    val data2 = stackData.pop()
                    ans = data2 - data1
                }
                "*" -> {
                    ans = stackData.pop() * stackData.pop()
                }
                "/" -> {
                    val data1 = stackData.pop()
                    val data2 = stackData.pop()
                    ans = data2 / data1
                }
            }
            stackData.push(ans)
        } else {
            stackData.push(Integer.parseInt(it))
        }
    }

    return stackData.peek()
}