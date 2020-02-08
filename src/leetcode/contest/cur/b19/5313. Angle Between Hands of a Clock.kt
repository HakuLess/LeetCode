package leetcode.contest.cur.b19

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5313()
    s.angleClock(12, 30).print()
    s.angleClock(4, 50).print()
}

class Solution5313 {
    fun angleClock(hour: Int, minutes: Int): Double {
        val it = abs(hour * 30 - 5.5 * minutes)
        return minOf(it, 360 - it)
    }
}
