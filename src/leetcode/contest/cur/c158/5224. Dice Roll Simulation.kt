package leetcode.contest.cur.c158

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
                        for (k in 0 until 20) {
                            p2[i][0] += p[j][k]
                            p2[i][0] %= mod
                        }
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
        var ans = 0
        for (i in 0 until 6) {
            for (j in 0 until 20) {
                ans += p[i][j]
                ans %= mod
            }
        }
        return ans % mod
    }
}