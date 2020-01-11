package leetcode.contest.cur.b17

class Solution5143 {
    fun decompressRLElist(nums: IntArray): IntArray {
        val ans = ArrayList<Int>()
        for (i in nums.indices step 2) {
            for (j in 0 until nums[i])
                ans.add(nums[i + 1])
        }
        return ans.toIntArray()
    }
}