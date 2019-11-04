package leetcode.normal

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = Solution775()
    s.isIdealPermutation(intArrayOf(1, 0, 2)).print()
    s.isIdealPermutation(intArrayOf(1, 2, 0)).print()
}

class Solution775 {
    fun isIdealPermutation(A: IntArray): Boolean {
        var res = 0
        for (i in 0 until A.size - 1) {
            if (res > A[i + 1]) {
                return false
            }
            res = maxOf(res, A[i])
        }
        return true
//        var local = 0
//        for (i in 0 until A.lastIndex) {
//            if (A[i] > A[i + 1]) {
//                local++
//            }
//        }
//
//        var global = 0
//        for (i in 0 until A.lastIndex) {
//            for (j in i + 1..A.lastIndex) {
//                if (A[i] > A[j]) {
//                    global++
//                }
//            }
//        }
//        return local == global
    }
}