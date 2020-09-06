package leetcode.contest.cur.leetcode.c205

import java.lang.StringBuilder

class Solution5507 {
    fun modifyString(s: String): String {
        val sb = StringBuilder()
        val ca = s.toCharArray()
        for (i in ca.indices) {
            if (ca[i] != '?') {
                sb.append(s[i])
            } else {
                for (c in 'a'..'z') {
                    if (i - 1 in ca.indices && c == ca[i - 1]) {
                        continue
                    }
                    if (i + 1 in ca.indices && c == ca[i + 1]) {
                        continue
                    }
                    ca[i] = c
                    sb.append(c)
                    break
                }
            }
        }
        return sb.toString()
    }
}