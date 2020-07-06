package leetcode.contest.cur.leetcode.c196

class Solution5452 {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        if (arr.size == 2) {
            return true
        }
        arr.sort()
        val diff = arr[1] - arr[0]
        for (i in 0 until arr.lastIndex) {
            if (arr[i + 1] - arr[i] != diff) {
                return false
            }
        }
        return true
    }
}