package leetcode.contest.cur.leetcode.c243

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5773()
    s.maxValue("99", 9).print()
}

class Solution5773 {
    fun maxValue(n: String, x: Int): String {
        val sb = StringBuilder(n)
        var isNeg = false
        for (i in sb.indices) {
            if (sb[i] == '-') {
                isNeg = true
                continue
            }
            if (isNeg) {
                if (x < sb[i] - '0') {
                    sb.insert(i, x)
                    return sb.toString()
                }
            } else {
                if (x > sb[i] - '0') {
                    sb.insert(i, x)
                    return sb.toString()
                }
            }
        }
        return sb.append(x).toString()
    }
}