package leetcode.contest.cur.leetcode.c211

class Solution5545 {
    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        var arr = ArrayList<Pair<Int, Int>>()
        for (i in scores.indices) {
            arr.add(Pair(scores[i], ages[i]))
        }
        arr = ArrayList(arr.sortedWith(compareBy({ it.second }, { it.first })))
        val dp = IntArray(scores.size) { 0 }
        for (i in dp.indices) {
            dp[i] = arr[i].first
            var res = i
            var ans = Int.MIN_VALUE
            for (j in i - 1 downTo 0) {
                if (arr[i].second == arr[j].second || arr[i].first >= arr[j].first) {
                    if (dp[j] > ans) {
                        ans = dp[j]
                        res = j
                    }
                }
            }
            if (res in 0 until i) {
                dp[i] += dp[res]
            }
        }
        return dp.max()!!
    }
}