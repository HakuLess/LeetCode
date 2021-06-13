package leetcode.contest.cur.leetcode.c245

class Solution5785 {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        return triplets.filter { it[0] <= target[0] && it[1] <= target[1] && it[2] <= target[2] }.let {
            it.any { it[0] == target[0] } && it.any { it[1] == target[1] } && it.any { it[2] == target[2] }
        }
    }
}