package leetcode.contest.cur.c183

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution5377()
    s.numSteps("10").print()
    s.numSteps("11000").print()
    s.numSteps("1101").print()
    s.numSteps("1111110011101010110011100100101110010100101110111010111110110010").print()
}

class Solution5377 {
    fun numSteps(s: String): Int {
        if (s == "1") {
            return 0
        }
        if (s.all { it == '1' }) {
            return s.length + 1
        }
        return if (s.last() == '0') {
            1 + numSteps(s.substring(0, s.lastIndex))
        } else {
            val a = arrayListOf<Char>()
            a.addAll(s.toCharArray().toTypedArray())
            for (i in a.indices.reversed()) {
                if (a[i] == '1') {
                    a[i] = '0'
                } else {
                    a[i] = '1'
                    break
                }
            }
            1 + numSteps(a.joinToString(""))
        }
    }
}