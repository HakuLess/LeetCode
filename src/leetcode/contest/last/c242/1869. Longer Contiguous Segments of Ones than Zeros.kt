package leetcode.contest.last.c242

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1869()
    s.checkZeroOnes("1101").print()
}

class Solution1869 {
    fun checkZeroOnes(s: String): Boolean {
        var a0 = 0
        var a1 = 0
        var b0 = 0
        var b1 = 0
        s.forEach {
            if (it == '0') {
                a0++
                a1 = 0
                b0 = maxOf(b0, a0)
            } else {
                a1++
                a0 = 0
                b1 = maxOf(b1, a1)
            }
        }
        return b1 > b0
    }
}