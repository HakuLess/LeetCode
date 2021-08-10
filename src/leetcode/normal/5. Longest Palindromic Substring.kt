package leetcode.normal

import leetcode.contest.utils.manacher
import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5()
    s.longestPalindrome("babad").print()
    s.longestPalindrome("cbbd").print()
    s.longestPalindrome("ab").print()
    s.longestPalindrome("a").print()
}

class Solution5 {
    // 最长回文子字符串
    // 马拉车 Manacher
    fun longestPalindrome(s: String): String {
        val sb = StringBuilder()
        sb.append('#')
        s.forEach {
            sb.append(it)
            sb.append('#')
        }
        val manacher = manacher(sb.toString())
        var center = 0
        var max = 1
        for (i in manacher.indices) {
            if (manacher[i] > max) {
                center = i
                max = manacher[i]
            }
        }
//        sb.toString().print()
//        println("$center $max")
        if (max == 1) {
            return sb[1].toString()
        }
        return sb.substring(center - max, center + max).filter { it != '#' }
    }
}