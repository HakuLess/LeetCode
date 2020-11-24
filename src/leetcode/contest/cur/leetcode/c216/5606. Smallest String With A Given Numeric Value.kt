package leetcode.contest.cur.leetcode.c216

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5606()
//    s.getSmallestString(3, 27).print()
//    s.getSmallestString(5, 73).print()
    s.getSmallestString(24, 552).print()
    s.getSmallestString(96014, 2095650).print()
}

class Solution5606 {
    fun getSmallestString(n: Int, k: Int): String {
        val ans = IntArray(n) { 1 }
        var cur = k - n
        var index = ans.lastIndex
        while (cur != 0) {
            if (cur >= 25) {
                ans[index] += 25
                cur -= 25
            } else {
                ans[index] += cur
                cur = 0
            }
            index--
        }
        return ans.map { 'a' + it - 1 }.joinToString("")
    }
}