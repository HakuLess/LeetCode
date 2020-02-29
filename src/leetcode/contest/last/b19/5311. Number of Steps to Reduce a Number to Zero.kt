package leetcode.contest.last.b19

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5311()
    s.numberOfSteps(14).print()
}

class Solution5311 {
    fun numberOfSteps(num: Int): Int {
        var ans = 0
        var cur = num
        while (cur != 0) {
            if (cur % 2 == 0) {
                cur /= 2
            } else {
                cur--
            }
            ans++
        }
        return ans
    }
}