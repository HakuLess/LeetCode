package leetcode.contest.cur.leetcode.c209

class Solution5531 {
    fun specialArray(nums: IntArray): Int {
        val n = nums.size
        for (i in 0..n) {
            if (nums.count { it >= i } == i) {
                return i
            }
        }
        return -1
    }
}