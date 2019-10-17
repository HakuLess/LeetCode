package leetcode.contest.last.c157

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5218()
    s.countVowelPermutation(1).print()
    s.countVowelPermutation(2).print()
    s.countVowelPermutation(5).print()
    s.countVowelPermutation(144).print()
}

class Solution5218 {
    fun countVowelPermutation(n: Int): Int {
        if (n == 0) {
            return 0
        }
        val mod = 1000000007

        var a = 1
        var e = 1
        var i = 1
        var o = 1
        var u = 1
        for (j in 1 until n) {
            val a2 = ((e + i) % mod) + u
            val e2 = a + i
            val i2 = e + o
            val o2 = i
            val u2 = i + o

            a = a2 % mod
            e = e2 % mod
            i = i2 % mod
            o = o2 % mod
            u = u2 % mod
        }
        return (((((a + e) % mod) + i) % mod + o) % mod + u) % mod
    }
}