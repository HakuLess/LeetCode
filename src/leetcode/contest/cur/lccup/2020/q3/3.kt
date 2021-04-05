package leetcode.contest.cur.`2020`.q3

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution3()
    s.minimumOperations("rrryyyrryyyrr").print()
    s.minimumOperations("ryr").print()
}

class Solution3 {
    fun minimumOperations(leaves: String): Int {
        val n = leaves.length
        val f = Array(n) { IntArray(3) }
        f[0][0] = if (leaves[0] == 'y') 1 else 0
        f[1][2] = Int.MAX_VALUE
        f[0][2] = f[1][2]
        f[0][1] = f[0][2]
        for (i in 1 until n) {
            val isRed = if (leaves[i] == 'r') 1 else 0
            val isYellow = if (leaves[i] == 'y') 1 else 0
            f[i][0] = f[i - 1][0] + isYellow
            f[i][1] = minOf(f[i - 1][0], f[i - 1][1]) + isRed
            if (i >= 2) {
                f[i][2] = minOf(f[i - 1][1], f[i - 1][2]) + isYellow
            }
        }
        return f[n - 1][2]
    }
}