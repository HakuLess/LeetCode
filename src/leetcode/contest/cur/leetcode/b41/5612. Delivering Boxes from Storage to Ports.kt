package leetcode.contest.cur.leetcode.b41

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5612()
    s.boxDelivering(
        arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(1, 1)
        ), 2, 3, 3
    ).print()
//    [[2, 4], [2, 5], [3, 1], [3, 2], [3, 7], [3, 1], [4, 4], [1, 3], [5, 2]], portsCount = 5, maxBoxes = 5, maxWeight = 7
    s.boxDelivering(
        arrayOf(
            intArrayOf(2, 4),
            intArrayOf(2, 5),
            intArrayOf(3, 1),
            intArrayOf(3, 2),
            intArrayOf(3, 7),
            intArrayOf(3, 1),
            intArrayOf(4, 4),
            intArrayOf(1, 3),
            intArrayOf(5, 2)
        ), 5, 5, 7
    ).print()
}

// todo not finish
// 单调队列
// 尝试用DFS处理下
class Solution5612 {
    fun boxDelivering(boxes: Array<IntArray>, portsCount: Int, maxBoxes: Int, maxWeight: Int): Int {
        var w = boxes[0][1]
        var b = 1
        val dp = IntArray(boxes.size + 1)
        dp[1] = 2

        var cost = 2
        var i = 0
        var j = 1
        // i 是 left, j 是 right
        while (j in boxes.indices) {
            b++
            w += boxes[j][1]
            if (boxes[j][0] != boxes[j - 1][0]) cost++
            while (b > maxBoxes || w > maxWeight || dp[i + 1] == dp[i]) {
                b--
                w -= boxes[i][1]
                i++
                if (boxes[i][0] != boxes[i - 1][0]) cost--
            }
            dp[j + 1] = dp[i] + cost
            j++
        }
        return dp.last()
    }

//    fun boxDelivering(boxes: Array<IntArray>, portsCount: Int, maxBoxes: Int, maxWeight: Int): Int {
//        val n = boxes.size
//        val seen = HashMap<Pair<Int, Int>, Int>()
//        val preSum = IntArray(boxes.size)
//        for (i in boxes.indices) {
//            preSum[i] = boxes[i][1] + if (i == 0) 0 else preSum[i - 1]
//        }
//        val preChange = IntArray(boxes.size)
//        var left = -1
//        var change = 0
//        for (i in boxes.indices) {
//            if (boxes[i][0] != left) {
//                change++
//                left = boxes[i][0]
//            }
//            preChange[i] = change
//        }
//
//        fun dfs(i: Int, j: Int, weight: Int): Int {
//            if (i == j) return 2
//            val key = Pair(i, j)
//            if (key in seen) return seen[key]!!
//            val num = j - i + 1
//            if (weight <= maxWeight && num <= maxBoxes) {
//                var ans = 0
//                ans = 1 + preChange[j] - preChange[i]
//                ans++
//                return ans.also {
//                    seen[key] = it
//                }
//            } else {
//                var ans = Int.MAX_VALUE / 2
//                var cur = 0
//                for (t in i until j) {
//                    cur += boxes[t][1]
//                    ans = minOf(ans, dfs(i, t, cur) + dfs(t + 1, j, weight - cur))
//                }
//                return ans.also {
//                    seen[key] = it
//                }
//            }
//        }
//        return dfs(0, n - 1, preSum.last())
//    }
}