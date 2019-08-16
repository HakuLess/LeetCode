package leetcode.contest.cur

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution396()
    s.maxRotateFunction(intArrayOf(4, 3, 2, 6)).print()
    s.maxRotateFunction(intArrayOf()).print()
}

class Solution396 {
    fun maxRotateFunction(A: IntArray): Int {
        if (A.isEmpty()) {
            return 0
        }
        val sum = A.sum()
        var temp = 0
        for (i in 0 until A.size) {
            temp += A[i] * i
        }
        var ans = temp
        for (i in A.lastIndex downTo 1) {
            println("$temp, ${A[i]}, ${A.lastIndex}")
            temp += sum
            temp -= A[i] * A.size
            ans = maxOf(ans, temp)
        }
        return ans
    }
//    fun maxRotateFunction(A: IntArray): Int {
//        if (A.isEmpty()) {
//            return 0
//        }
//        val ans = IntArray(A.size) { 0 }
//        for (i in 0 until A.size) {
//            for (j in 0 until A.size) {
//                ans[j] += ((i + j) % A.size) * A[i]
//            }
//        }
//        ans.print()
//        return ans.max()!!
//    }
}