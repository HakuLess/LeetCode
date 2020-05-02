package leetcode.contest.cur.b25

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5385()
    s.maxDiff(555).print()
    s.maxDiff(9).print()
    s.maxDiff(123456).print()
    s.maxDiff(10000).print()
    s.maxDiff(9288).print()
}

class Solution5385 {
    fun maxDiff(num: Int): Int {
        val s = num.toString()
        if (s.length == 1) {
            return 8
        }
        return getMax(s) - getMin(s)
    }

    private fun getMin(s: String): Int {
        if (s[0] != '1') {
            return s.replace(s[0], '1').toInt()
        }
        for (i in 1..s.lastIndex) {
            if (s[i] != '0' && s[i] != s[0]) {
                return s.replace(s[i], '0').toInt()
            }
        }
        return s.toInt()
    }

    private fun getMax(s: String): Int {
        if (s.all { it == '9' })
            return s.toInt()
        val c = s.first { it != '9' }
        return s.replace(c, '9').toInt()
    }
}