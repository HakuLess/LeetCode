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
        var max = 0
        val sum = arrayListOf<Int>()
        var cur = 0
        for (i in s.indices) {
            cur += abs(s[i] - t[i])
            sum.add(cur)
        }
//        sum.forEach { print("$it,") }
//        println()
        for (i in s.indices) {
            if (sum[i] <= maxCost) {
                max = maxOf(i + 1, max)
            } else {
                var j = i - 1
                while (j >= 0 && sum[i] - sum[j] <= maxCost) {
                    max = maxOf(i - j, max)
                    j--
                }
            }
        }
        return max
    }

}