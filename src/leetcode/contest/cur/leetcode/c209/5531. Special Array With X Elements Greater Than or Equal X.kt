package leetcode.contest.cur.leetcode.c209

class Solution5531 {
    fun specialArray(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        for (i in n downTo 0) {
            for (j in 0 until n) {
                if (nums[j] >= i) {
                    if (n - j == i) {
                        return i
                    } else {
                        break
                    }
                }
            }
        }
        return -1
    }
}