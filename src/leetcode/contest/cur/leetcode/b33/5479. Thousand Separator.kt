package leetcode.contest.cur.leetcode.b33

import leetcode.contest.utils.print

fun main() {
    val s = Solution5479()
    s.thousandSeparator(123456789).print()
}

class Solution5479 {
    fun thousandSeparator(n: Int): String {
        val c = n.toString()
        var ans = ""
        var cur = 0
        c.reversed().forEach {
            if (cur == 3) {
                ans = ".$ans"
                cur = 0
            }
            ans = "$it$ans"
            cur++
        }
        return ans
    }
}