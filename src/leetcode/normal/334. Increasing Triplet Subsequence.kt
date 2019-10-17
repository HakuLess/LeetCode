package leetcode.normal

class Solution334 {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) {
            return false
        }
        val minArray = IntArray(nums.size)
        val maxArray = IntArray(nums.size)
        var min = nums[0]
        for (i in 0 until nums.size) {
            min = minOf(nums[i], min)
            minArray[i] = min
        }
        var max = nums[nums.lastIndex]
        for (i in nums.lastIndex downTo 0) {
            max = maxOf(nums[i], max)
            maxArray[i] = max
        }
        for (i in 1 until nums.lastIndex) {
            if (nums[i] > minArray[i] && nums[i] < maxArray[i]) {
                return true
            }
        }
        return false
    }
}