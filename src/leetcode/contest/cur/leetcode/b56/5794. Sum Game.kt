package leetcode.contest.cur.leetcode.b56

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5794()
    s.sumGame("?3295???").print()
    s.sumGame("25??").print()
//    s.sumGame("5023").print()
}

// 恶心题目
// 从Bob能赢的一点点希望入手
class Solution5794 {
    fun sumGame(num: String): Boolean {
        val n = num.length
        var x = 0
        var a = 0
        var b = 0
        for (i in 0 until n / 2) if (num[i] == '?') a++ else x += num[i] - '0'
        for (i in n / 2 until n) if (num[i] == '?') b++ else x -= num[i] - '0'
        return if ((a + b) % 2 == 1) true else (x - 9 * b + (a + b) / 2 * 9 != 0)
    }
}