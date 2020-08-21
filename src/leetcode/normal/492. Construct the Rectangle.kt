package leetcode.normal

import kotlin.math.sqrt

class Solution492 {
    fun constructRectangle(area: Int): IntArray {
        var a = sqrt(area.toFloat()).toInt()
        while (area % a != 0) {
            a++
        }
        return intArrayOf(a, area / a).sortedArrayDescending()
    }
}