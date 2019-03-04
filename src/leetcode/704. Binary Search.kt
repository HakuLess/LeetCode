package leetcode

class Solution704 {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        var middle = (left + right) shr 1

        while (left <= right) {
            println("$left $right $middle")
            middle = (left + right) shr 1
            when {
                nums[middle] > target -> {
                    right = middle - 1
                }
                nums[middle] < target -> {
                    left = middle + 1
                }
                else -> return middle
            }
        }

        return -1
    }
}