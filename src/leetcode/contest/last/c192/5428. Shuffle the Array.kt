package leetcode.contest.last.c192

class Solution5428 {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val ans = arrayListOf<Int>()
        for (i in 0 until n) {
            ans.add(nums[i])
            ans.add(nums[n + i])
        }
        return ans.toIntArray()
    }
}