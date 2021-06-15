package leetcode.contest.last.c237

class Solution5735 {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        var cur = coins
        var ans = 0
        costs.sort()
        for (i in costs.indices) {
            if (cur >= costs[i]) {
                ans++
                cur -= costs[i]
            } else {
                return ans
            }
        }
        return ans
    }
}