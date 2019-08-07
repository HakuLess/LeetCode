package leetcode.contest.last.b05

import leetcode.contest.utils.print
import kotlin.math.pow

fun main(args: Array<String>) {
    val s = Solution5028()
    s.isArmstrong(153).print()
    s.isArmstrong(123).print()
}

class Solution5028 {
    fun isArmstrong(N: Int): Boolean {
        val size = N.toString().length
        var n = N
        var ans = 0
        while (n != 0) {
            ans += (n % 10).toDouble().pow(size).toInt()
            n /= 10
        }
        return ans == N
    }
}