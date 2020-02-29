package leetcode.contest.last.c177

import leetcode.contest.utils.print
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val s = Solution5171()
    s.closestDivisors(8).print()
    s.closestDivisors(123).print()
    s.closestDivisors(999).print()
}

class Solution5171 {
    fun closestDivisors(num: Int): IntArray {
        val a = helper(num + 1)
        val b = helper(num + 2)
        if (a[1] - a[0] > b[1] - b[0]) {
            return b
        } else {
            return a
        }
    }

    private fun helper(num: Int): IntArray {
        var min = Int.MAX_VALUE / 2
        var ans = IntArray(2)
        for (i in 1..sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) {
                if (num / i - i < min) {
                    min = num / i - i
                    ans = intArrayOf(i, num / i)
                }
            }
        }
        return ans
    }
}