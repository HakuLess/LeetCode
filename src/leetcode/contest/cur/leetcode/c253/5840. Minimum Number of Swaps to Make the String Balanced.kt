package leetcode.contest.cur.leetcode.c253

import java.util.*

class Solution5840 {
    fun minSwaps(s: String): Int {
        var a = 0
        var b = 0
        var ans = 0
        s.forEach {
            if (it == ']') {
                if (b != 0) b--
                else if (a == 0) {
                    b++
                    ans++
                }
                else if (a != 0) a--
            } else {
                a++
            }
        }
        return ans
    }
}