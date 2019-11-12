package leetcode.normal

class Solution34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        var left = 0
        var right = nums.lastIndex
        var ans = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                ans = mid
                break
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        if (ans == -1) {
            return intArrayOf(-1, -1)
        }
        var start = ans
        var end = ans
        while (start > 0 && nums[start - 1] == nums[start]) {
            start--
        }
        while (end < nums.lastIndex && nums[end + 1] == nums[end]) {
            end++
        }
        return intArrayOf(start, end)
    }
}