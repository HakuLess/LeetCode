package leetcode.contest.cur.leetcode.c217

class Solution5613 {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var ans = 0
        accounts.forEach {
            ans = maxOf(ans, it.sum())
        }
        return ans
    }
}