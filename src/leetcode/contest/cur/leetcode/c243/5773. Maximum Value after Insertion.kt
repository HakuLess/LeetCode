package leetcode.contest.cur.leetcode.c243

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5773()
    s.maxValue("99", 9).print()
}

class Solution5773 {
    fun maxValue(n: String, x: Int): String {
        val neg = n[0] == '-'
        val ans = StringBuilder()
        var add = false
        if (neg) {
            for (i in n.indices) {
                if (i == 0) {
                    ans.append(n[i])
                    continue
                }
                if (n[i] - '0' > x && !add) {
                    ans.append(x)
                    ans.append(n[i])
                    add = true
                } else {
                    ans.append(n[i])
                }
            }
        } else {
            for (i in n.indices) {
                if (n[i] - '0' < x && !add) {
                    ans.append(x)
                    ans.append(n[i])
                    add = true
                } else {
                    ans.append(n[i])
                }
            }
        }
        if (!add) {
            ans.append(x)
        }
        return ans.toString()
    }
}