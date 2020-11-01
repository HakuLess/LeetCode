package leetcode.contest.cur.leetcode.c213

class Solution5554 {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        val target = arr.joinToString(",")
        for (piece in pieces) {
            if (piece.joinToString(",") !in target) {
                return false
            }
        }
        return true
    }
}