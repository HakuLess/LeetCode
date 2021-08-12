package leetcode.contest.last.c159

class Solution5233 {
    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val w = arrayListOf<Triple<Int, Int, Int>>()
        for (i in startTime.indices) {
            w.add(Triple(startTime[i], endTime[i], profit[i]))
        }
        w.sortBy { it.second }
        val dp = IntArray(w.size)
        dp[0] = w[0].third
        for (i in 1 until w.size) {
            dp[i] = maxOf(w[i].third, dp[i - 1])
            for (j in i - 1 downTo 0) {
                if (w[j].second <= w[i].first) {
                    dp[i] = maxOf(dp[i], w[i].third + dp[j])
                    break
                }
            }
        }
        return dp.maxOrNull()!!
    }
}