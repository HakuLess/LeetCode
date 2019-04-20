package leetcode.normal

class Solution414 {
    fun thirdMax(nums: IntArray): Int {
        val res = nums.distinct().sortedDescending()
        if (res.size < 3) {
            return res[0]
        }
        return res[2]
    }
}