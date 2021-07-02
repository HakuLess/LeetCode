package leetcode.normal

import kotlin.math.sqrt

class Solution441 {
    fun arrangeCoins(n: Int): Int {
        if (n == 0) {
            return 0
        }
        return ((sqrt(1 + 8 * n.toDouble()) - 1) / 2).toInt()
    }
}