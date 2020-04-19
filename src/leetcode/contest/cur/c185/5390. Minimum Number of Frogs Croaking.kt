package leetcode.contest.cur.c185

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5390()
    s.minNumberOfFrogs("croakcroak").print()
    s.minNumberOfFrogs("crcoakroak").print()
}

class Solution5390 {
    fun minNumberOfFrogs(croakOfFrogs: String): Int {
        if (croakOfFrogs.isEmpty()) {
            return 0
        }
        var c = 0
        var r = 0
        var o = 0
        var a = 0
        var k = 0
        var ans = 1
        croakOfFrogs.forEach {
            when (it) {
                'c' -> c++
                'r' -> r++
                'o' -> o++
                'a' -> a++
                'k' -> k++
            }
            if (k > a || a > o || o > r || r > c) {
                return -1
            }
            ans = maxOf(ans, c - k)
        }
        if (k == a && a == o && o == r && r == c) {
            return ans
        }
        return -1
    }
}