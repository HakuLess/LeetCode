package leetcode.contest.cur.c191

class Solution5424 {
    fun maxProduct(nums: IntArray): Int {
        var a = 0
        var b = 0
        for (i in nums.indices) {
            if (nums[i] > a) {
                b = a
                a = nums[i]
            } else if (nums[i] > b) {
                b = nums[i]
            }
        }
        return (a - 1) * (b - 1)
//        var ans = Int.MIN_VALUE
//        for (i in nums.indices) {
//            for (j in i + 1 until nums.size) {
//                ans = maxOf(ans, (nums[i] - 1) * (nums[j] - 1))
//            }
//        }
//        return ans
    }
}