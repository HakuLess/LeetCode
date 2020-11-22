package leetcode.contest.cur.leetcode.c216

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5606()
//    s.getSmallestString(3, 27).print()
//    s.getSmallestString(5, 73).print()
//    s.getSmallestString(24, 552).print()
    s.getSmallestString(96014, 2095650).print()
}

class Solution5606 {
    fun getSmallestString(n: Int, k: Int): String {
        val ans = StringBuilder()
        var cur = k
        var c = n
        while ((c - 1) * 26 >= cur) {
            ans.append("a")
            c--
            cur--
        }
        val left = StringBuilder()
        while (cur != 0) {
            if (cur >= 26) {
                left.append("z")
                cur -= 26
            } else {
                left.append('a' + cur - 1)
                cur = 0
            }
        }
        return "${ans}${left.reversed()}"
    }
}