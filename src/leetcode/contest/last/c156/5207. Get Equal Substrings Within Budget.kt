package leetcode.contest.last.c156

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5207()
    s.equalSubstring("abcd", "bcdf", 3).print()
    s.equalSubstring("abcd", "cdef", 3).print()
    s.equalSubstring("krrgw", "zjxss", 19).print()
    s.equalSubstring("pxezla", "loewbi", 25).print()
}

class Solution5207 {

    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        var left = 0
        var cost = 0
        var ans = 0
        for (i in s.indices) {
            cost += abs(s[i] - t[i])
            while (cost > maxCost) {
                cost -= abs(s[left] - t[left])
                left++
            }
            ans = maxOf(ans, i - left + 1)
        }
        return ans
    }
}