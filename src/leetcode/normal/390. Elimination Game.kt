package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

// todo not finish
fun main(args: Array<String>) {
    val s = Solution390()
    s.lastRemaining(9).print()
    s.lastRemaining(10).print()
}

class Solution390 {
    fun lastRemaining(n: Int): Int {
        return when {
            n == 2 -> 2
            n == 1 -> 1
            n % 2 == 1 -> lastRemaining(n - 1)
            else -> 2 * (n / 2 + 1 - lastRemaining(n / 2))
        }
    }
}