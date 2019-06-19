package leetcode.contest.c141

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1092()
//    s.shortestCommonSupersequence("abac", "cab").print()
    s.shortestCommonSupersequence("bbbaaaba", "bbababbb").print()
}

class Solution1092 {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        return ""
    }

//    fun shortestCommonSupersequence(str1: String, str2: String): String {
//        val max1 = getMin(str1, str2)
//        val max2 = getMin(str2, str1)
//        return if (max1.length > max2.length) {
//            max2
//        } else {
//            max1
//        }
//    }
//
//    private fun getMin(str1: String, str2: String): String {
//        if (str1.indexOf(str2) != -1) {
//            return str1
//        }
//        var max = ""
//        for (i in 0 until str2.length) {
//            if (str1.lastIndex - i < 0) {
//                break
//            }
//            val sub = str1.substring(IntRange(str1.lastIndex - i, str1.lastIndex))
//            val l = lcp(arrayOf(sub, str2))
//            if (l.length > max.length) {
//                max = l
//            }
//        }
//
//        val ans = str1 + str2.substring(max.lastIndex + 1, str2.lastIndex + 1)
//        ans.print()
//        return ans
//    }
//
//    fun lcp(strs: Array<String>): String {
//        if (strs.isEmpty()) {
//            return ""
//        }
//        var prefix = strs[0]
//        for (i in 1 until strs.size) {
//            while (strs[i].indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length - 1)
//                if (prefix.isEmpty()) {
//                    return ""
//                }
//            }
//        }
//        return prefix
//    }
}