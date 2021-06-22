package leetcode.contest.last.c246

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5788()
    s.largestOddNumber("35427").print()
}

class Solution5788 {
    fun largestOddNumber(num: String): String {
        for (i in num.indices.reversed()) {
            if ((num[i] - '0') % 2 == 1) {
                return num.substring(0, i + 1)
            }
        }
        return ""
    }
}