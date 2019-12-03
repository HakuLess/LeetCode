package leetcode.normal

class Solution75 {
    fun sortColors(nums: IntArray): Unit {
        var l = 0
        var r = nums.lastIndex
        var cur = 0
        while (cur <= r) {
            when (nums[cur]) {
                0 -> {
                    swap(nums, l, cur)
                    l++
                    cur++
                }
                2 -> {
                    swap(nums, r, cur)
                    r--
                }
                else -> {
                    cur++
                }
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[j]
        nums[j] = nums[i]
        nums[i] = temp
    }


//    fun sortColors(nums: IntArray): Unit {
//        nums.sort()
//    }
}