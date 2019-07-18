package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution926()
    s.minFlipsMonoIncr("00110").print()
    s.minFlipsMonoIncr("010110").print()
    s.minFlipsMonoIncr("00000").print()
    s.minFlipsMonoIncr("0011000010").print()
}

class Solution926 {
    fun minFlipsMonoIncr(S: String): Int {
        val left = IntArray(S.length)
        val right = IntArray(S.length)
        var cur = 0
        for (i in 0..S.lastIndex) {
            left[i] = cur
            if (S[i] == '1') {
                cur++
            }
        }

        cur = 0
        for (i in S.lastIndex downTo 0) {
            right[i] = cur
            if (S[i] == '0') {
                cur++
            }
        }

        left.print()
        right.print()
        var result = Int.MAX_VALUE
        for (i in 0..S.lastIndex) {
            result = minOf(result, left[i] + right[i])
        }
        return result
    }
}