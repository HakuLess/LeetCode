package leetcode.normal

import java.lang.StringBuilder

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    val sb = StringBuilder()
    var min = strs[0].length
    strs.forEach {
        if (it.length < min) {
            min = it.length
        }
    }
    for (i in 0 until min) {
        var ch = ' '
        strs.forEachIndexed { index, s ->
            when {
                index == 0 -> ch = s[i]
                ch != s[i] -> return sb.toString()
            }
        }
        sb.append(ch)
    }

    return sb.toString()
}