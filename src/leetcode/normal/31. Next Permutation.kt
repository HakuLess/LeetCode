package leetcode.normal


class Solution31 {
    fun nextPermutation(nums: IntArray) {
        for (i in nums.size - 2 downTo 0) {
            for (j in nums.size - 1 downTo i + 1) {
                if (nums[j] > nums[i]) {
                    val temp = nums[i]
                    nums[i] = nums[j]
                    nums[j] = temp
                    nums.sort(i + 1, nums.size)
                    return
                }
            }
        }
        nums.reverse()
    }
//    fun nextPermutation(nums: IntArray) {
//        var i = nums.size - 2
//        while (i >= 0 && nums[i + 1] <= nums[i]) {
//            i--
//        }
//        if (i >= 0) {
//            var j = nums.size - 1
//            while (j >= 0 && nums[j] <= nums[i]) {
//                j--
//            }
//            swap(nums, i, j)
//        }
//        reverse(nums, i + 1)
//    }
//
//    private fun reverse(nums: IntArray, start: Int) {
//        var i = start
//        var j = nums.size - 1
//        while (i < j) {
//            swap(nums, i, j)
//            i++
//            j--
//        }
//    }
//
//    private fun swap(nums: IntArray, i: Int, j: Int) {
//        val temp = nums[i]
//        nums[i] = nums[j]
//        nums[j] = temp
//    }
}