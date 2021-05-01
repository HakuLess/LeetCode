package leetcode.contest.cur.leetcode.b51

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5730()
    s.replaceDigits("a1c1e1").print()
}

class Solution5730 {
    fun replaceDigits(s: String): String {
        val ans = StringBuilder()
        for (i in s.indices) {
            if (i % 2 == 0) {
                ans.append(s[i])
            } else {
                ans.append(s[i - 1] + (s[i] - '0'))
            }
        }
        return ans.toString()
    }
}