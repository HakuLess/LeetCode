package leetcode.contest.last.b19

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5311()
    s.numberOfSteps(14).print()
}

class Solution5311 {
    fun numberOfSteps(num: Int): Int {
        return num.toString(2).groupingBy { it }.eachCount().let {
            (it['0'] ?: 0) + (it['1'] ?: 0) * 2 - 1
        }
    }
}