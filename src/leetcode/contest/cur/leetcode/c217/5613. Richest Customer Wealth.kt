package leetcode.contest.cur.leetcode.c217

class Solution5613 {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        return accounts.map { it.sum() }.maxOrNull()!!
    }
}