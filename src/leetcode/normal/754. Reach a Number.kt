package leetcode.normal

import kotlin.math.abs

fun reachNumber(target: Int): Int {
    val t = abs(target)
    var sum = 0
    var step = 0
    while (sum < t) {
        step++
        sum += step
    }
    while ((t - sum) % 2 != 0) {
        step++
        sum += step
    }
    return step
}
