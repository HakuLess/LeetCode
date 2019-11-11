package leetcode.contest.last.c161

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5247()
    s.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx").print()
    s.minimumSwap("xy", "yx").print()
    s.minimumSwap("xx", "yy").print()
    s.minimumSwap("xx", "xy").print()
}

class Solution5247 {
    fun minimumSwap(s1: String, s2: String): Int {
        var a = 0
        var b = 0
        for (i in s1.indices) {
            if (s1[i] == s2[i]) {
                continue
            } else if (s1[i] == 'x' && s2[i] == 'y') {
                a++
            } else {
                b++
            }
        }

//        a.print()
//        b.print()
        if ((a + b) % 2 != 0) {
            return -1
        }
        return a % 2 + a / 2 + b % 2 + b / 2
    }
}