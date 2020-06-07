package leetcode.contest.cur.c192

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5431()
//    s.minCost(intArrayOf(0, 0, 0, 0, 0), arrayOf(
//            intArrayOf(1, 10),
//            intArrayOf(10, 1),
//            intArrayOf(10, 1),
//            intArrayOf(1, 10),
//            intArrayOf(5, 1)
//    ), 5, 2, 3).print()

    s.minCost(intArrayOf(0, 2, 1, 2, 0), arrayOf(
            intArrayOf(1, 10),
            intArrayOf(10, 1),
            intArrayOf(10, 1),
            intArrayOf(1, 10),
            intArrayOf(5, 1)
    ), 5, 2, 3).print()
}

class Solution5431 {

    fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
        val seen = HashMap<String, Int>()
        fun helper(i: Int, color: Int, left: Int): Int {
            val key = "$i, $color, $left"
            if (key in seen)
                return seen[key]!!
            var cur = Int.MAX_VALUE / 2
            if (left < 0)
                return cur
            if (i == m)
                return if (left == 0) 0 else cur
            if (houses[i] == 0) {
                if (i == 0)
                    for (k in 0 until n)
                        cur = minOf(cur, cost[i][k] + helper(i + 1, k, left - 1))
                else
                    for (k in 0 until n)
                        cur = minOf(cur, cost[i][k] + helper(i + 1, k, left - if (k == color) 0 else 1))
            } else {
                cur = helper(i + 1, houses[i] - 1, left - if (houses[i] - 1 == color) 0 else 1)
            }
            seen[key] = cur
            return cur
        }
        val ans = helper(0, -1, target)
        return if (ans >= Int.MAX_VALUE / 2) -1 else ans
    }


//    val seen = HashMap<String, Int>()
//
//    fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
//        var ans = helper(houses, cost, 0, n, target)
//        if (ans >= Int.MAX_VALUE / 2) {
//            return -1
//        }
//        return ans
//    }
//
//    private fun helper(houses: IntArray, cost: Array<IntArray>, cur: Int, n: Int, target: Int): Int {
//        if (check(houses) > target) {
//            return Int.MAX_VALUE / 2
//        }
//        if (cur !in houses.indices) {
//            return if (check(houses) == target) {
//                0
//            } else {
//                Int.MAX_VALUE / 2
//            }
//        }
//        if ("${houses[cur]}, $cur, ${check(houses)}" in seen) {
//            return seen["${houses[cur]}, $cur, ${check(houses)}"]!!
//        }
//        var ans = Int.MAX_VALUE / 2
//        if (houses[cur] == 0) {
//            for (i in 0 until n) {
//                houses[cur] = i + 1
//                ans = minOf(ans, helper(houses.clone(), cost, cur + 1, n, target) + cost[cur][i])
//            }
//        } else {
//            ans = helper(houses.clone(), cost, cur + 1, n, target)
//        }
//        seen["${houses[cur]}, $cur, ${check(houses)}"] = ans
//        return ans
//    }
//
//    private fun check(houses: IntArray): Int {
//        var ans = 0
//        var last = -1
//        houses.forEach {
//            if (it != 0) {
//                if (it != last) {
//                    ans++
//                    last = it
//                }
//            }
//        }
//        return ans
//    }
}