package leetcode.normal

class Solution611 {
    fun triangleNumber(nums: IntArray): Int {
        nums.sort()
        var ans = 0
        for (i in 0 until nums.size - 2) {
            for (j in i + 1 until nums.size - 1) {
                for (k in j + 1 until nums.size) {
                    if (nums[i] + nums[j] > nums[k]) {
                        ans++
                    } else {
                        break
                    }
                }
            }
        }
        return ans
    }
}