package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution397()
    s.integerReplacement(8).print()
    s.integerReplacement(7).print()
    s.integerReplacement(65535).print()
    s.integerReplacement(2147483647).print()
}

class Solution397 {
    fun integerReplacement(n: Int): Int {
        var m = n
        var count = 0
        while (m != 1) {
            // odd
            if (m and 1 == 1) {
                // if previous bit is zero -> -1, else -> +1
                if (m == 3 || m.ushr(1) and 1 == 0) {
                    m--
                } else {
                    m++
                }
            } else {
                // even
                m = m ushr 1
            }
            count++
        }
        return count
    }

//    fun integerReplacement(n: Int): Int {
//        if (n == 1) {
//            return 0
//        }
//        return if (n % 2 == 0) {
//            1 + integerReplacement(n / 2)
//        } else {
//            2 + minOf(integerReplacement(n / 2 + 1), integerReplacement(n / 2))
//        }
//    }
}