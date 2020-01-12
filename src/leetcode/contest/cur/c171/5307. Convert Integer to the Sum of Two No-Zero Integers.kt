package leetcode.contest.cur.c171

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5307()
    s.getNoZeroIntegers(11).print()
}

class Solution5307 {
    fun getNoZeroIntegers(n: Int): IntArray {
        var a = 1
        while (a.toString().contains('0') || (n - a).toString().contains('0')) {
            a++
        }
        return intArrayOf(a, n - a)
    }
}