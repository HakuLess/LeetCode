package leetcode.contest.cur.leetcode.c246

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5788()
    s.largestOddNumber("35427").print()
}

class Solution5788 {
    fun largestOddNumber(num: String): String {
        if (num.all { (it - '0') % 2 == 0 }) return ""
        var last = 0
        for (i in num.indices) {
            if ((num[i] - '0') % 2 == 1) {
                last = i
                println(last)
            }
        }
        return num.substring(0, last + 1)
    }
}