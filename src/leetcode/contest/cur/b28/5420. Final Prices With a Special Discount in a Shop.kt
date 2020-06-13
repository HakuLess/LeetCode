package leetcode.contest.cur.b28

class Solution5420 {
    fun finalPrices(prices: IntArray): IntArray {
        var ans = arrayListOf<Int>()
        for (i in prices.indices) {
            var add = false
            for (j in i + 1..prices.lastIndex) {
                if (prices[j] <= prices[i]) {
                    ans.add(prices[i] - prices[j])
                    add = true
                    break
                }
            }
            if (!add) {
                ans.add(prices[i])
            }
        }
        return ans.toIntArray()
    }
}