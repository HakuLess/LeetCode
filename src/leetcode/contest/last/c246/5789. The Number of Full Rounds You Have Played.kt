package leetcode.contest.last.c246

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5789()
//    s.numberOfRounds("12:01", "12:44").print()
//    s.numberOfRounds("20:00", "06:00").print()
//    s.numberOfRounds("00:00", "23:59").print()
    s.numberOfRounds("00:47", "00:57").print()
}

class Solution5789 {
    fun numberOfRounds(startTime: String, finishTime: String): Int {
        val (sh, sm) = startTime.split(":").map { it.toInt() }
        val (fh, fm) = finishTime.split(":").map { it.toInt() }
        val s = sh * 60 + sm
        var f = fh * 60 + fm
        if (f < s) {
            f += 60 * 24
        }
        val rf = f / 15 * 15
        return maxOf(0, (rf - s)) / 15
    }
}