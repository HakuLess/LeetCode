package leetcode.normal

class Solution11 {

    fun maxArea(height: IntArray): Int {
        var max = 0
        var l = 0
        var r = height.size - 1
        while (l < r) {
            max = maxOf(max, minOf(height[l], height[r]) * (r - l))
            if (height[l] < height[r])
                l++
            else
                r--
        }
        return max
    }

//    fun maxArea(height: IntArray): Int {
//        var ans = 0
//        for (i in 0 until height.size - 1) {
//            for (j in i + 1 until height.size) {
//                ans = maxOf(ans, (j - i) * minOf(height[j], height[i]))
//            }
//        }
//
//        return ans
//    }
}