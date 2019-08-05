package leetcode.contest.last.c136

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution5057()
//    s.maxSumAfterPartitioning(intArrayOf(1, 15, 7, 9, 2, 5, 10), 3).print()
    s.maxSumAfterPartitioning(intArrayOf(581920, 200100, 526972, 677934, 989025, 294832, 581857, 663919, 961334, 1881, 859626, 251114, 361905, 867006, 86001, 836946, 894279, 859796, 750025, 898166, 674980, 939280, 458563, 117387, 403337, 961067, 589597, 73584, 178968, 955900, 755634, 609754, 97612, 19699, 843950, 907919, 883083, 522938, 670930, 671679, 390248, 704834, 188158, 226340, 80496, 701795, 867627, 280988, 465918, 748627, 321025, 564279, 79716, 786173), 23).print()
}

class Solution5057 {
    fun maxSumAfterPartitioning(A: IntArray, K: Int): Int {
        val dp = IntArray(A.size)
        dp[0] = A[0]

        for (i in 1 until A.size) {
            var maxSum = A[i] + dp[i - 1]
            var maxVal = A[i]
            var j = i - 1
            while (j >= 0 && j > i - K) {
                maxVal = maxOf(maxVal, A[j])
                maxSum = if (j == 0) {
                    maxOf(maxSum, maxVal * (i - j + 1))
                } else {
                    maxOf(maxVal * (i - j + 1) + dp[j - 1], maxSum)
                }
                j--
            }
            dp[i] = maxSum
        }

        return dp[A.size - 1]
    }
//    val hashMap = hashMapOf<Int, Int>()
//
//    fun maxSumAfterPartitioning(A: IntArray, K: Int): Int {
//        if (A.size in hashMap) {
//            return hashMap[A.size]!!
//        }
//
//        return if (K >= A.size) {
//            hashMap[A.size] = A.size * A.max()!!
//            A.size * A.max()!!
//        } else {
//            var max = 0
//            val list = arrayListOf<Int>()
//            for (i in 0 until K) {
//                list.add(A[i])
//                max = maxOf(list.max()!! * list.size
//                        + maxSumAfterPartitioning(A.slice(IntRange(i + 1, A.lastIndex)).toIntArray(), K), max)
//            }
//            hashMap[A.size] = max
//            max
//        }
//    }
}