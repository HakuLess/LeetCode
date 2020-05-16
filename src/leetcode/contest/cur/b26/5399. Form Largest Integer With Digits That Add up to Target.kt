package leetcode.contest.cur.b26

import leetcode.contest.utils.print
import kotlin.math.cos

fun main() {
    val s = Solution5399()
    s.largestNumber(intArrayOf(4, 3, 2, 5, 6, 7, 2, 5, 5), 9).print()
    s.largestNumber(intArrayOf(6, 10, 15, 40, 40, 40, 40, 40, 40), 47).print()
}

class Solution5399 {
    fun largestNumber(cost: IntArray, target: Int): String {
        val dp = Array<String>(5001) { "" }
        for (i in 1..target) {
            for (j in 1..9) {
                if (i - cost[j - 1] in dp.indices && (dp[i - cost[j - 1]].isNotEmpty() || i - cost[j - 1] == 0)) {
                    dp[i] = getMax(j.toString() + dp[i - cost[j - 1]], dp[i])
                    dp[i] = getMax(dp[i - cost[j - 1]] + j.toString(), dp[i])
                }
            }
        }
//        for (i in 1..target) {
//            println("$i, ${dp[i]}")
//        }
        if (dp[target].isEmpty()) {
            return "0"
        }
        return dp[target]
    }

//    var ans = ""
//    fun largestNumber(cost: IntArray, target: Int): String {
//        helper("", cost, 0, target)
//        return ans
//    }
//
//    private fun helper(cur: String, cost: IntArray, curCost: Int, target: Int) {
//        if (curCost == target) {
//            ans = getMax(cur, ans)
//        }
//        if (curCost > target) {
//            return
//        }
//        for (i in cost.indices) {
//            helper(cur + "${i + 1}", cost, curCost + cost[i], target)
//        }
//    }
//
    private fun getMax(str1: String, str2: String): String {
        return when {
            str1.length > str2.length -> {
                str1
            }
            str1.length == str2.length -> {
                maxOf(str1, str2)
            }
            else -> {
                str2
            }
        }
    }
}