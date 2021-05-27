package leetcode.contest.cur.leetcode.c242

import leetcode.contest.utils.print
import kotlin.math.ceil
import kotlin.math.floor

fun main(args: Array<String>) {
    val s = Solution1870()
    s.minSpeedOnTime(intArrayOf(1, 3, 2), 2.7).print()
}

class Solution1870 {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        if (hour < dist.size - 1) return -1
        fun check(mid: Int): Boolean {
            var ans = 0.0
            dist.forEach {
                ans = ceil(ans)
                ans += it.toDouble() / mid
            }
            println("$mid : $ans")
            return ans <= hour
        }

        var left = 1
        var right = Int.MAX_VALUE / 2
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when {
                check(mid) -> right = mid
                else -> left = mid
            }
        }
        return if (check(left)) {
            left
        } else {
            right
        }
    }
}