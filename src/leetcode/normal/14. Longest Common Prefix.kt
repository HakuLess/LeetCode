package leetcode.normal

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution14()
    s.longestCommonPrefix(arrayOf("aa", "a")).print()
}

class Solution14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        var prefix = strs[0]
        for (i in strs.indices) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.lastIndex)
                if (prefix.isEmpty()) return ""
            }
        }
        return prefix
    }

//    fun longestCommonPrefix(strs: Array<String>): String {
//        if (strs.isEmpty()) {
//            return ""
//        }
//        val sb = StringBuilder()
//        for (i in strs[0].indices) {
//            var ch = ' '
//            strs.forEachIndexed { index, s ->
//                when {
//                    index == 0 -> ch = s.getOrNull(i) ?: ' '
//                    ch != s.getOrNull(i) ?: '-' -> return sb.toString()
//                }
//            }
//            sb.append(ch)
//        }
//        return sb.toString()
//    }
}