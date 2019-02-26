package leetcode

import kotlin.math.max

fun main(args: Array<String>) {
    findRadius(intArrayOf(1, 5), intArrayOf(2)).print()
}

fun findRadius(houses: IntArray, heaters: IntArray): Int {
    var left = 0
    var right = max(houses.last(), heaters.last())

    while (left < right) {
        val mid = left + (right - left) / 2
        if (isHeaters(houses, heaters, mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

fun isHeaters(houses: IntArray, heaters: IntArray, radius: Int): Boolean {
    houses.forEach {
        var isHot = false
        for (i in 0 until heaters.size) {
            if (Math.abs(it - heaters[i]) <= radius) {
                isHot = true
                break
            }
        }

        if (!isHot) {
            return false
        }
    }
    return true
}