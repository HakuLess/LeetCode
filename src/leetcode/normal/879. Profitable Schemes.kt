package leetcode.normal

class Solution879 {
    // 三维背包 人、利润 作为两个成本维度
    fun profitableSchemes(n: Int, minProfit: Int, group: IntArray, profit: IntArray): Int {
        val dp = Array(n + 1) { IntArray(minProfit + 1) }
        for (i in 0..n) {
            dp[i][0] = 1
        }
        val len: Int = group.size
        val mod = 1e9.toInt() + 7
        for (i in 1..len) {
            // 需要的 人数 和 利润
            val m = group[i - 1]
            val p = profit[i - 1]
            for (j in n downTo m) {
                for (k in minProfit downTo 0) {
                    // 这个maxOf精髓，把sum超过minProfit的
                    dp[j][k] = (dp[j][k] + dp[j - m][maxOf(0, k - p)]) % mod
                }
            }
        }
        return dp[n][minProfit]
    }
}