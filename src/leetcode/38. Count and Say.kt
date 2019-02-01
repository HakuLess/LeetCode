package leetcode

import java.lang.StringBuilder

fun main(args: Array<String>) {
    countAndSay(6).print()
}

fun countAndSay(n: Int): String {
    if (n == 1) {
        return "1"
    }

    return compute(countAndSay(n - 1))
}

fun compute(str: String): String {
    val result = StringBuilder()
    var curChar: Char = str[0]
    var curCount = 0
    str.forEach {
        if (curChar == it) {
            curCount++
        } else {
            result.append(curCount)
            result.append(curChar)
            curCount = 1
            curChar = it
        }
    }

    if (curCount > 0) {
        result.append(curCount)
        result.append(curChar)
    }

    return result.toString()
}