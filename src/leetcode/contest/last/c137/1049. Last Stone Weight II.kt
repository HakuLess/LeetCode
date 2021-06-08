package leetcode.contest.last.c137

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1049()
//    s.lastStoneWeightII(intArrayOf(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 14, 23, 37, 61, 98)).print()
    s.lastStoneWeightII(intArrayOf(7, 14, 15, 7, 7)).print()
}

class Solution1049 {
    // 动态规划 DP
    fun lastStoneWeightII(stones: IntArray): Int {
        val sum = stones.sum()
        // 尽量找到 sum / 2 的总和，转换为0、1背包
        val m = sum / 2
        val dp = BooleanArray(m + 1)
        dp[0] = true
        for (weight in stones) {
            for (j in m downTo weight) {
                dp[j] = dp[j] || dp[j - weight]
            }
        }
        return sum - 2 * dp.lastIndexOf(true)
    }

//    fun lastStoneWeightII(stones: IntArray): Int {
//        var set = hashSetOf<Int>()
//        stones.forEach {
//            if (set.isEmpty()) {
//                set.add(it)
//                set.add(-it)
//            } else {
//                val temp = hashSetOf<Int>()
//                set.forEach { item ->
//                    temp.add(item - it)
//                    temp.add(it + item)
//                }
//                set = temp
//            }
//        }
//        val ans = set.sortedBy { abs(it) }
//        return abs(ans[0])
//    }
}