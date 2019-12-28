package leetcode.contest.cur.b16

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5135()
    s.findBestValue(intArrayOf(4, 9, 3), 10).print()
    s.findBestValue(intArrayOf(2, 3, 5), 10).print()
    s.findBestValue(intArrayOf(60864, 25176, 27249, 21296, 20204), 56803).print()
    s.findBestValue(intArrayOf(60864, 25176, 27249, 21296, 20204), 1).print()
}

class Solution5135 {
    fun findBestValue(arr: IntArray, target: Int): Int {
        var left = 0
        var right = 100000

        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when {
                (getInt(arr, mid) >= target) -> right = mid
                else -> left = mid
            }
        }
        return if (abs(getInt(arr, left) - target) <= abs(getInt(arr, right) - target)) {
            left
        } else {
            right
        }
    }

    private fun getInt(arr: IntArray, t: Int): Int {
        var ans = 0
        arr.forEach {
            ans += if (it > t) {
                t
            } else {
                it
            }
        }
        return ans
    }
}