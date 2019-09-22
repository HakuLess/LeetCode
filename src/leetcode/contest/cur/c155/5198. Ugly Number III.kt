package leetcode.contest.cur.c155

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5198()
    s.nthUglyNumber(5, 2, 11, 13).print()
    s.nthUglyNumber(4, 2, 3, 4).print()
    s.nthUglyNumber(1000000000, 2, 217983653, 336916467).print()
}

class Solution5198 {
    fun nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int {
        var l = 0
        var r = Int.MAX_VALUE
        while (l < r) {
            val mid = l + (r - l) / 2
            if (checkMid(mid.toLong(), a.toLong(), b.toLong(), c.toLong()) < n) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        return l
    }

    private fun checkMid(n: Long, a: Long, b: Long, c: Long): Long {
        var answer = n / a + n / b + n / c
        answer -= n / lcm(a, b) + n / lcm(b, c) + n / lcm(c, a)
        answer += n / lcm(lcm(a, b), c)
        return answer
    }

    private fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }

    private fun lcm(a: Long, b: Long): Long {
        return a / gcd(a, b) * b
    }
}