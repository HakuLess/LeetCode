package leetcode.normal

import kotlin.math.max

/**
 * Created by HaKu on 27/02/2018.
 */
fun main(args: Array<String>) {
    val array: IntArray = intArrayOf(2, 1, 5, 6, 2, 3)
    largestRectangleArea(array)
}

fun largestRectangleArea(heights: IntArray): Int {

    val range = heights.distinct()
    var result = 0
    for (height in range) {
        val width = heights.getLongest {
            it >= height
        }
//        if (width * height > result) {
//            result = width * height
//        }
        result = max(result, width * height)
        println("$width,$height,$result")
    }
    return result
}

fun IntArray.getLongest(func: (item: Int) -> Boolean): Int {
    var last = 0
    var maxLast = 0
    this.forEach {
        if (func(it)) {
            last++
            if (maxLast < last) {
                maxLast = last
            }
        } else {
            last = 0
        }
    }
    return maxLast
}