package leetcode.contest.cur.leetcode.c241

import leetcode.contest.utils.print

fun main() {
    val s = Solution5760()
    s.minSwaps("111000").print()
    s.minSwaps("100").print()
    s.minSwaps("011010").print()
    s.minSwaps("11111000000").print()
}

class Solution5760 {
    fun minSwaps(s: String): Int {
        val a0 = s.count { it == '0' }
        val a1 = s.count { it == '1' }
        if (a0 - a1 > 1 || a0 - a1 < -1) return -1
        var ans0 = Int.MAX_VALUE
        if (a0 - a1 == 1 || a0 == a1) {
            ans0 = 0
            for (i in s.indices) {
                if (i % 2 == 0) {
                    if (s[i] != '0') ans0++
                } else {
                    if (s[i] != '1') ans0++
                }
            }
        }
        var ans1 = Int.MAX_VALUE / 2
        if (a1 - a0 == 1 || a0 == a1) {
            ans1 = 0
            for (i in s.indices) {
                if (i % 2 == 0) {
                    if (s[i] != '1') ans1++
                } else {
                    if (s[i] != '0') ans1++
                }
            }
        }
        return minOf(ans0 / 2, ans1 / 2)
    }
}