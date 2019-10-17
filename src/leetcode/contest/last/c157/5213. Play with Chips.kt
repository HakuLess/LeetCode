package leetcode.contest.last.c157

class Solution5213 {
    fun minCostToMoveChips(chips: IntArray): Int {
        var v1 = 0
        var v2 = 0
        chips.forEach {
            if (it % 2 == 0) {
                v1++
            } else {
                v2++
            }
        }
        return minOf(v1, v2)
    }
}