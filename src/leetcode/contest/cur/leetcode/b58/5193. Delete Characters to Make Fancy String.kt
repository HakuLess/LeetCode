package leetcode.contest.cur.leetcode.b58

import java.lang.StringBuilder

class Solution5193 {
    fun makeFancyString(s: String): String {
        val ans = StringBuilder()
        s.forEach {
            if (ans.length < 2)
                ans.append(it)
            else if (ans[ans.length - 1] != it || ans[ans.length - 2] != it) {
                ans.append(it)
            }
        }
        return ans.toString()
    }
}