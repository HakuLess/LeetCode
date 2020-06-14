package leetcode.contest.cur.c193

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = TreeAncestor(7, intArrayOf(-1, 0, 0, 1, 1, 2, 2))
    s.getKthAncestor(3, 1).print()
    s.getKthAncestor(6, 3).print()
}

class TreeAncestor(val n: Int, val parent: IntArray) {

    val dp = Array<IntArray>(n) { IntArray(18) { -1 } }

    init {
        for (i in 0 until n) {
            dp[i][0] = parent[i]
        }
        for (k in 1 until 18) {
            for (i in 0 until n) {
                if (dp[i][k - 1] == -1) {
                    continue
                }
                dp[i][k] = dp[dp[i][k - 1]][k - 1]
            }
        }
    }

    fun getKthAncestor(node: Int, k: Int): Int {
        var cur = node
        for (i in 17 downTo 0) {
            if (k and (1 shl i) > 0) {
                cur = dp[cur][i]
                if (cur == -1)
                    break
            }
        }
        return cur
    }
}