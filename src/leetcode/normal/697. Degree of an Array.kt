package leetcode.normal


class Solution697 {
    fun findShortestSubArray(nums: IntArray): Int {
        val left = hashMapOf<Int, Int>()
        val right = hashMapOf<Int, Int>()
        val count = hashMapOf<Int, Int>()

        for (i in nums.indices) {
            val x = nums[i]
            if (left[x] == null) {
                left[x] = i
            }
            right[x] = i
            count[x] = count.getOrDefault(x, 0) + 1
        }

        var ans = nums.size
        val degree = count.values.max()!!
        for (x in count.keys) {
            if (count[x] == degree) {
                ans = minOf(ans, right[x]!! - left[x]!! + 1)
            }
        }
        return ans
    }
}