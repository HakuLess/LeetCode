package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution788()
    s.rotatedDigits(30).print()
}

class Solution788 {

    private val rotate = intArrayOf(0, 1, 2, 5, 6, 8, 9)
    private val self = intArrayOf(0, 1, 8)

    fun rotatedDigits(N: Int): Int {
        var ans = 0
        for (i in 1..N) {
            if (isGood(i)) {
                println(i)
                ans++
            }
        }
        return ans
    }

    private fun isGood(N: Int): Boolean {
        var n = N
        while (n > 0) {
            if (n % 10 !in rotate) {
                return false
            } else {
                n /= 10
            }
        }

        n = N
        while (n > 0) {
            if (n % 10 !in self) {
                return true
            } else {
                n /= 10
            }
        }
        return false
    }
}