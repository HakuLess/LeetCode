package leetcode.normal

class Solution42 {
    fun trap(height: IntArray): Int {
        val left = IntArray(height.size)
        val right = IntArray(height.size)

        var leftMax = 0
        for (i in 0 until height.size) {
            leftMax = maxOf(leftMax, height[i])
            if (i == 0) {
                left[i] = 0
            } else {
                left[i] = leftMax
            }
        }
        left.forEach {
            print("$it, ")
        }
        println()

        var rightMax = 0
        for (i in height.lastIndex downTo 0) {
            rightMax = maxOf(rightMax, height[i])
            if (i == height.lastIndex) {
                right[i] = 0
            } else {
                right[i] = rightMax
            }
        }
        right.forEach {
            print("$it, ")
        }
        println()

        var ans = 0
        for (i in 0 until height.size) {
            ans += maxOf(minOf(left[i], right[i]) - height[i], 0)
        }
        return ans
    }
}