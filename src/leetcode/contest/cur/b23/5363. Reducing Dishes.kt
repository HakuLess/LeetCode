package leetcode.contest.cur.b23

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.List
import kotlin.collections.contains
import kotlin.collections.lastIndex
import kotlin.collections.set
import kotlin.collections.sortedBy


fun main(args: Array<String>) {
    val s = Solution5363()
    s.maxSatisfaction(intArrayOf(34, -27, -49, -6, 65, 70, 72, -37, -57, 92, -72, 36, 6, -91, 18, 61, 77, -91, 5, 64, -16, 5, 20,
            -60, -94, -15, -23, -10, -61, 27, 89, 38, 46, 57, 33, 94, -79,
            43, -67, -73, -39, 72, -52, 13, 65, -82, 26, 69, 67)).print()
}

class Solution5363 {

    fun maxSatisfaction(satisfaction: IntArray): Int {
        satisfaction.sort()
        val n = satisfaction.size
        var cur = 0
        var ans = 0
        var sum = 0
        for (i in n - 1 downTo 0) {
            sum += satisfaction[i]
            cur += sum
            ans = maxOf(ans, cur)
        }
        return ans
    }

//    val seen = HashMap<Pair<Int, Int>, Int>()
//    fun maxSatisfaction(satisfaction: IntArray): Int {
//        val s = satisfaction.sortedBy { it }
//        return helper(s, 0, 0, 1)
//    }
//
//    private fun helper(s: List<Int>, i: Int, sum: Int, d: Int): Int {
//        if (Pair(i, d) in seen) {
//            return seen[Pair(i, d)]!!
//        }
//        if (i > s.lastIndex) {
//            return sum
//        }
//        val ans = maxOf(
//                helper(s, i + 1, sum, d),
//                helper(s, i + 1, sum + d * s[i], d + 1)
//        )
//        seen[Pair(i, d)] = ans
//        return ans
//    }
}