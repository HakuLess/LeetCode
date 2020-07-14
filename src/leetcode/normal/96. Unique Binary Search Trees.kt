package leetcode.normal

class Solution96 {
    fun numTrees(n: Int): Int {
        if (n == 0) {
            return 1
        }

        val f = IntArray(n + 1)
        f[0] = 1
        f[1] = 1

        for (i in 2..n) {
            for (j in 1..i) {
                f[i] += f[j - 1] * f[i - j]
            }
        }
        return f[n]
    }
}