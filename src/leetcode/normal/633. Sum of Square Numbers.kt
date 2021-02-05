package leetcode.normal

import leetcode.contest.utils.print
import kotlin.math.floor
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val a = Solution633()
//    a.judgeSquareSum(456666).print()
//    a.judgeSquareSum(2147483641).print()
    a.judgeSquareSum(0).print()
}

class Solution633 {
    fun judgeSquareSum(c: Int): Boolean {
        var i = 0
        val max = sqrt(Int.MAX_VALUE.toDouble())
        while (i * i <= c) {
            if (i > max) {
                return false
            }
            val sq = sqrt((c - i * i).toDouble())
            if (sq == floor(sq)) {
                return true
            }
            i++
        }
        return false
    }
}