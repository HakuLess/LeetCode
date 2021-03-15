package leetcode.normal

class Solution334 {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) {
            return false
        }
        val minArray = IntArray(nums.size)
        val maxArray = IntArray(nums.size)
        var min = nums[0]
        for (i in nums.indices) {
            min = minOf(nums[i], min)
            minArray[i] = min
        }
        var max = nums[nums.lastIndex]
        for (i in nums.indices.reversed()) {
            max = maxOf(nums[i], max)
            maxArray[i] = max
        }
        return (1 until nums.lastIndex).any {
            nums[it] > minArray[it] && nums[it] < maxArray[it]
        }
    }
}