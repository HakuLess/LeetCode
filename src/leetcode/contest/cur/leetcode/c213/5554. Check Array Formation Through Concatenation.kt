package leetcode.contest.cur.leetcode.c213

class Solution5554 {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        val target = arr.joinToString(separator = ",", prefix = ",", postfix = ",")
        for (piece in pieces) {
            if (piece.joinToString(separator = ",", prefix = ",", postfix = ",") !in target) {
                return false
            }
        }
        return true
    }
}