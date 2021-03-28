package leetcode.contest.cur.leetcode.c234

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5715()
    s.reinitializePermutation(1000).print()
}

class Solution5715 {
    fun reinitializePermutation(n: Int): Int {
        var cur = IntArray(n) { i -> i }
        val ans = cur.joinToString(",")
        val tmp = IntArray(n) { i -> i }
        var c = 0
        do {
            c++
            for (i in cur.indices) {
                if (i % 2 == 0) {
                    tmp[i] = cur[i / 2]
                } else {
                    tmp[i] = cur[n / 2 + (i - 1) / 2]
                }
            }
            cur = tmp.clone()
        } while (cur.joinToString(",") != ans)
        return c
    }
}