package leetcode.contest.cur.leetcode.b31

class Solution5456 {
    fun countOdds(low: Int, high: Int): Int {
        return (high - low) / 2 + if (high % 2 == 1) 1 else 0 + if (high % 2 == 1) 1 else 0 + if ((high - low) % 2 == 1) 1 else 0
    }
}