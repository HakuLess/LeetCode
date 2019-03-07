package leetcode

import java.lang.StringBuilder

class Solution151 {
    fun reverseWords(s: String): String {
        val ans = StringBuilder()
        s.trim().split(' ').reversed().forEach {
            if (it.isNotBlank()) {
                ans.append(it)
                ans.append(" ")
            }
        }

        return ans.trim().toString()
    }
}