package leetcode.normal

class Solution983 {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val prices = IntArray(366)
        prices[0] = 0
        for (i in 1..365) {
            if (i in days) {
                prices[i] = arrayListOf(
                        prices.getOrElse(i - 1) { 0 } + costs[0],
                        prices.getOrElse(i - 7) { 0 } + costs[1],
                        prices.getOrElse(i - 30) { 0 } + costs[2]
                ).min()!!
            } else {
                prices[i] = prices[i - 1]
            }
        }

        return prices[days[days.lastIndex]]
    }
}