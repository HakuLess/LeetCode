package leetcode.contest.cur.leetcode.c246

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5789()
    s.numberOfRounds("12:01", "12:44").print()
    s.numberOfRounds("20:00", "06:00").print()
    s.numberOfRounds("00:00", "23:59").print()
}

class Solution5789 {
    fun numberOfRounds(startTime: String, finishTime: String): Int {
        val (sh, sm) = startTime.split(":").map { it.toInt() }
        val (fh, fm) = finishTime.split(":").map { it.toInt() }

        val sme = if (sm % 15 == 0) sm else ((sm / 15) + 1) * 15
        val fme = ((fm / 15)) * 15

        var min = (fh - sh) * 60 + fme - sme
        if (min < 0) min += 24 * 60
        return min / 15
    }
}