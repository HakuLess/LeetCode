package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1000()
    s.mergeStones(intArrayOf(3, 2, 4, 1), 2).print()
//    s.mergeStones(intArrayOf(4, 6, 4, 7, 5), 2).print()
    s.mergeStones(intArrayOf(3, 5, 1, 2, 6), 3).print()
}

class Solution1000 {

    fun mergeStones(stones: IntArray, K: Int): Int {
        val n = stones.size
        if ((n - 1) % (K - 1) > 0) {
            return -1
        }

        val sum = IntArray(n + 1)
        for (i in 0 until n) {
            sum[i + 1] = sum[i] + stones[i]
        }

        val dp = Array(n) { IntArray(n) }
        for (m in K..n) {
            for (i in 0..n - m) {
                val j = i + m - 1

                println("$i, $j")
                dp[i][j] = Integer.MAX_VALUE
                var mid = i
                while (mid < j) {
                    // dp[i][j] = min{dp[i][mid] + dp[mid + 1][j]}
                    dp[i][j] = minOf(dp[i][j], dp[i][mid] + dp[mid + 1][j])
                    mid += K - 1
                }
                if ((j - i) % (K - 1) == 0) {
                    dp[i][j] += sum[j + 1] - sum[i]
                }
            }
        }
        return dp[0][n - 1]
    }

//    fun mergeStones(stones: IntArray, K: Int): Int {
//        val n = stones.size
//        if ((n - 1) % (K - 1) > 0) {
//            return -1
//        }
//
//        val sum = IntArray(n + 1)
//        for (i in 0 until n) {
//            sum[i + 1] = sum[i] + stones[i]
//        }
//
//        val dp = Array(n) { Array(n) { IntArray(K + 1) { 99999 } } }
//        for (i in 0 until n) {
//            dp[i][i][1] = 0
//        }
//
//        for (l in 2..n) {
//            for (i in 0..n - l) {
//                val j = i + l - 1
//                println("$i, $j, $l")
//                for (k in 2..K) {
//                    for (m in i until j step K - 1) {
//                        println("get $i $m $j  $k")
//                        dp[i][j][k] = minOf(dp[i][j][k], dp[m + 1][j][k - 1] + dp[i][m][1])
//                    }
//                }
//                dp[i][j][1] = dp[i][j][K] + sum[j + 1] - sum[i]
//            }
//        }
//        return dp[0][n - 1][1]
//    }

//    var result = 0
//
//    fun mergeStones(stones: IntArray, K: Int): Int {
//        if (stones.size % (K - 1) != 1 && K != 2) {
//            return -1
//        }
//        getValue(stones, K)
//        return result
//    }
//
//    fun getValue(stones: IntArray, K: Int) {
//        stones.print()
//        if (stones.isEmpty() || stones.size == 1) {
//            return
//        }
//
//        var min = Integer.MAX_VALUE
//        var index = 0
//
//        for (i in 0..stones.size - K) {
//            var sum = 0
//            for (j in 0 until K) {
//                sum += stones[i + j]
//            }
//
//            if (sum < min) {
//                index = i
//                min = sum
//            }
//        }
//        result += min
//
//        // merge index i to i + k - 1
//        val mergedStone = IntArray(stones.size - K + 1)
//        for (i in 0 until mergedStone.size) {
//            when {
//                i < index -> mergedStone[i] = stones[i]
//                i > index -> mergedStone[i] = stones[i + K - 1]
//                else -> {
//                    var sum = 0
//                    for (j in 0 until K) {
//                        sum += stones[index + j]
//                    }
//                    mergedStone[i] = sum
//                }
//            }
//        }
//
//        getValue(mergedStone, K)
//    }
}