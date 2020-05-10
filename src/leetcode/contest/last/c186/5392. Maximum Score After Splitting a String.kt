package leetcode.contest.last.c186

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5392()
    s.maxScore("00111").print()
}

class Solution5392 {
    fun maxScore(s: String): Int {
        var ans = 0
        for (i in 1..s.lastIndex) {
            val left = s.substring(0, i)
            val right = s.substring(i, s.length)
            println("$left, $right")
            ans = maxOf(left.count { it == '0' } + right.count { it == '1' }, ans)
        }
        return ans
    }
}