package leetcode.normal

import java.lang.StringBuilder

fun replaceWords(dict: List<String>, sentence: String): String {
    val sb = StringBuilder()
    var replace = false
    sentence.split(' ').forEach {
        replace = false
        for (prefix in dict) {
            if (it.startsWith(prefix)) {
                sb.append("$prefix ")
                replace = true
                break
            }
        }
        if (!replace) {
            sb.append("$it ")
        }
    }
    return sb.toString().trimEnd()
}