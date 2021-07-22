package leetcode.contest.last.c157

class Solution5213 {
    fun minCostToMoveChips(chips: IntArray): Int {
        return minOf(chips.count { it % 2 == 0 }, chips.count { it % 2 == 1 })
    }
}