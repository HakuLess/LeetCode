package leetcode.normal

import java.util.*

/**
 * Created by HaKu on 27/02/2018.
 */
fun main(args: Array<String>) {
    val s = Solution84()
    val array: IntArray = intArrayOf(2, 1, 5, 6, 2, 3)
    s.largestRectangleArea(array)
}

class Solution84 {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = Stack<Int>()
        stack.push(-1)
        var maxArea = 0
        for (i in heights.indices) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                maxArea = maxOf(maxArea, heights[stack.pop()] * (i - stack.peek() - 1))
            }
            stack.push(i)
        }
        while (stack.peek() != -1) {
            maxArea = maxOf(maxArea, heights[stack.pop()] * (heights.size - stack.peek() - 1))
        }
        return maxArea
    }

//    fun largestRectangleArea(heights: IntArray): Int {
//        val range = heights.distinct()
//        var result = 0
//        for (height in range) {
//            val width = heights.getLongest {
//                it >= height
//            }
//            result = maxOf(result, width * height)
//        }
//        return result
//    }
//
//    private fun IntArray.getLongest(func: (item: Int) -> Boolean): Int {
//        var last = 0
//        var maxLast = 0
//        this.forEach {
//            if (func(it)) {
//                last++
//                if (maxLast < last) {
//                    maxLast = last
//                }
//            } else {
//                last = 0
//            }
//        }
//        return maxLast
//    }
}