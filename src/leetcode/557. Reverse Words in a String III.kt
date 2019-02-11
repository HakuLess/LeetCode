package leetcode

import java.lang.StringBuilder

fun reverseWords(s: String): String {
    val result = StringBuilder()
    s.split(" ").forEach {
        result.append(it.reversed()).append(" ")
    }
    return result.toString().removeSuffix(" ")
}