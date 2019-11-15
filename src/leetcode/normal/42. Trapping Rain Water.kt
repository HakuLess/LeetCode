package leetcode.normal

class Solution42 {
    fun trap(height: IntArray): Int {
        val left = IntArray(height.size)
        val right = IntArray(height.size)

        var leftMax = 0
        for (i in height.indices) {
            leftMax = maxOf(leftMax, height[i])
            left[i] = if (i == 0) {
                0
            } else {
                leftMax
            }
        }

        var rightMax = 0
        for (i in height.lastIndex downTo 0) {
            rightMax = maxOf(rightMax, height[i])
            right[i] = if (i == height.lastIndex) {
                0
            } else {
                rightMax
            }
        }

        var ans = 0
        for (i in height.indices) {
            ans += maxOf(minOf(left[i], right[i]) - height[i], 0)
        }
        return ans
    }
}