package leetcode.contest.cur.leetcode.b31

class Solution5456 {
    fun countOdds(low: Int, high: Int): Int {
        var ans = (high - low) / 2
        if (high % 2 == 1 || low % 2 == 1) {
            ans++
        }
        return ans
    }
}