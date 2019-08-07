package leetcode.contest.last.c147

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1138()
    s.alphabetBoardPath("leet").print()
    s.alphabetBoardPath("code").print()
    s.alphabetBoardPath("zdz").print()
    s.alphabetBoardPath("zb").print()
}

class Solution1138 {
    fun alphabetBoardPath(target: String): String {
        var ans = ""
        var cur = Pair(0, 0)
        var pre = ' '
        target.forEach {
            val next = getPos(it)
            ans += getRoute(cur, next, it, pre)
            cur = next
            pre = it
        }
        return ans
    }

    private fun getRoute(cur: Pair<Int, Int>, next: Pair<Int, Int>, target: Char, pre: Char): String {
        var ans = ""

        for (i in 0 until cur.second - next.second) {
            ans += "L"
        }
        for (i in 0 until cur.first - next.first) {
            ans += "U"
        }
        for (i in 0 until next.second - cur.second) {
            ans += "R"
        }
        for (i in 0 until next.first - cur.first) {
            ans += "D"
        }

        ans += "!"
        return ans
    }

    private fun getPos(c: Char): Pair<Int, Int> {
        val t = c - 'a'
        return Pair(t / 5, t % 5)
    }
}