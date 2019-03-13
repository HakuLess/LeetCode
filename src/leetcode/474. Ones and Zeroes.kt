package leetcode

fun main(args: Array<String>) {
    val s = Solution474()
//    s.findMaxForm(arrayOf("10", "0001", "111001", "1", "0"), 5, 3).print()
//    s.findMaxForm(arrayOf("10", "0", "1", "1", "0"), 1, 1).print()
//    s.findMaxForm(arrayOf("0", "1101", "01", "00111", "1", "10010", "0", "0", "00", "1", "11", "0011"), 63, 36).print()
    s.findMaxForm(arrayOf("0", "11", "1000", "01", "0", "101", "1", "1", "1", "0", "0", "0", "0", "1", "0", "0110101", "0", "11", "01", "00", "01111", "0011", "1", "1000", "0", "11101", "1", "0", "10", "0111"), 9, 80).print()

}

class Solution474 {

    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val res = strs.map {
            Pair(it.count { ch ->
                ch == '0'
            }, it.count { ch ->
                ch == '1'
            })
        }

        val dp = Array(m + 1) { IntArray(n + 1) }
        res.forEach {
            for (i in m downTo it.first) {
                for (j in n downTo it.second) {
                    dp[i][j] = maxOf(dp[i][j], 1 + dp[i - it.first][j - it.second])
                }
            }
        }

        dp.print()
        return dp[m][n]
    }
}