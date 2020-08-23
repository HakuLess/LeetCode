package leetcode.contest.cur.leetcode.c203

class Solution5496 {
    fun maxCoins(piles: IntArray): Int {
        piles.sortDescending()
        val t = piles.size / 3
        var ans = 0
        for (i in 0 until t) {
            ans += piles[i * 2 + 1]
        }
        return ans
    }
}