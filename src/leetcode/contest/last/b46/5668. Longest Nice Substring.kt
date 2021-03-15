package leetcode.contest.last.b46

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5668()
    s.longestNiceSubstring("YazaAay").print()
}

class Solution5668 {
    fun longestNiceSubstring(s: String): String {
        var ans = ""
        fun check(str: String): Boolean {
            return str.all {
                it.toUpperCase() in str && it.toLowerCase() in str
            }
        }
        for (i in s.indices) {
            for (j in i until s.length) {
                val item = s.substring(i, j + 1)
                if (check(item) && item.length > ans.length)
                    ans = item
            }
        }
        return ans
    }
}