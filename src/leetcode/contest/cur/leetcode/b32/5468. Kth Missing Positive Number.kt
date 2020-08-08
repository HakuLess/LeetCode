package leetcode.contest.cur.leetcode.b32

class Solution5468 {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var ans = 0
        for (i in 1..2001) {
            if (i !in arr) {
                ans++
            }
            if (ans == k) {
                return i
            }
        }
        return 0
    }
}