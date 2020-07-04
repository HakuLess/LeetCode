package leetcode.contest.last.c194

class Solution5440 {
    fun xorOperation(n: Int, start: Int): Int {
        val nums = IntArray(n)
        for (i in nums.indices) {
            nums[i] = start + 2 * i
        }
        var ans = 0
        nums.forEach {
            ans = ans xor it
        }
        return ans
    }
}