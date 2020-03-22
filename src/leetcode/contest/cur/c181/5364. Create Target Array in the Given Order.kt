package leetcode.contest.cur.c181

class Solution5364 {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val a = ArrayList<Int>()
        for (i in nums.indices) {
            a.add(index[i], nums[i])
        }
        return a.toIntArray()
    }
}