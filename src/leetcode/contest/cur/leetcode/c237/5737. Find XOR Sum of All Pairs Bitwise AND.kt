package leetcode.contest.cur.leetcode.c237

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5737()
    s.getXORSum(intArrayOf(1, 2, 3), intArrayOf(6, 5)).print()
    s.getXORSum(intArrayOf(12), intArrayOf(4)).print()
}

class Solution5737 {
    fun getXORSum(arr1: IntArray, arr2: IntArray): Int {
        val a = arr1.fold(0) { a, b -> a xor b }
        val b = arr2.fold(0) { a, b -> a xor b }
        return a and b
    }

//    fun getXORSum(arr1: IntArray, arr2: IntArray): Int {
//        val a = IntArray(32)
//        val b = IntArray(32)
//        for (i in arr1.indices) {
//            for (j in 0 until 32) {
//                if (arr1[i] and (1 shl j) != 0) {
//                    a[j]++
//                    a[j] %= 2
//                }
//            }
//        }
//
//        for (i in arr2.indices) {
//            for (j in 0 until 32) {
//                if (arr2[i] and (1 shl j) != 0) {
//                    b[j]++
//                    b[j] %= 2
//                }
//            }
//        }
//        var ans = 0
//        var step = 1
//        for (i in a.indices) {
//            ans += a[i] * b[i] * step
//            step *= 2
//        }
//        return ans
//    }
}