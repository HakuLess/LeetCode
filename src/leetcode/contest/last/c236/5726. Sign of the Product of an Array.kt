package leetcode.contest.last.c236

class Solution5726 {
    fun arraySign(nums: IntArray): Int {
        var a = 1
        nums.forEach {
            if (it < 0) a = -a
            if (it == 0) return 0
        }
        return a
    }
}