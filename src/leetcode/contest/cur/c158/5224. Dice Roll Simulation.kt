package leetcode.contest.cur.c158

import leetcode.contest.utils.print
import leetcode.contest.utils.sumMod

fun main(args: Array<String>) {
    val s = Solution5224()
    s.dieSimulator(2, intArrayOf(1, 1, 2, 2, 2, 3)).print()
}

class Solution5224 {
    fun dieSimulator(n: Int, rollMax: IntArray): Int {
        val mod = 1000000007

        var p = Array(6) { IntArray(20) }
        for (i in 0 until 6) {
            p[i][0] = 1
        }
        for (t in 1 until n) {
            val p2 = Array(6) { IntArray(20) }
            for (i in 0..5) {
                for (j in 0..5) {
                    if (i != j) {
                        p2[i][0] += p[j].sumMod(mod)
                        p2[i][0] %= mod
                    }
                }
            }
            for (i in 0..5) {
                for (j in 1 until rollMax[i]) {
                    p2[i][j] = p[i][j - 1]
                    p2[i][j] %= mod
                }
            }
            p = p2
        }
//        p.print()
        var ans = 0
        for (i in 0 until 6) {
            ans += p[i].sumMod(mod)
            ans %= mod
        }
        return ans % mod
    }
}