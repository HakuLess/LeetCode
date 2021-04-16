package leetcode.normal

import java.util.*

class Solution475 {
    fun findRadius(houses: IntArray, heaters: IntArray): Int {
        houses.sort()
        val ts = TreeSet<Long>()
        ts.addAll(heaters.map { it.toLong() })
        ts.add(Long.MAX_VALUE / 2)
        ts.add(Long.MIN_VALUE / 2)
        var ans = 0L
        houses.map { it.toLong() }.forEach {
            val left = ts.floor(it)!!
            val right = ts.ceiling(it)!!
            ans = maxOf(ans, minOf(it - left, right - it))
        }
        return ans.toInt()
    }
}