package leetcode.contest.cur.leetcode.c197

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5461()
    s.numSub("0110111").print()
}

class Solution5461 {
    fun numSub(s: String): Int {
        val mod = 1000000007L
        var ans = 0L
        var cur = 0L
        s.forEach {
            if (it == '1') {
                cur++
                ans += cur
            } else {
                cur = 0
            }
        }
        return (ans % mod).toInt()
    }
}