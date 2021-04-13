package leetcode.contest.last.c138

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val a = Solution1053()
    a.prevPermOpt1(intArrayOf(3, 2, 1)).print()
    a.prevPermOpt1(intArrayOf(1, 1, 5)).print()
    a.prevPermOpt1(intArrayOf(1, 9, 4, 6, 7)).print()
    a.prevPermOpt1(intArrayOf(3, 1, 1, 3)).print()
    a.prevPermOpt1(intArrayOf(5, 3, 1, 1, 3)).print()
}

class Solution1053 {
    fun prevPermOpt1(A: IntArray): IntArray {

        fun swap(i: Int, j: Int) {
            val temp = A[i]
            A[i] = A[j]
            A[j] = temp
        }

        var last = -1
        for (i in A.lastIndex downTo 1) {
            if (A[i] < A[i - 1]) {
                last = i - 1
                break
            }
        }
        if (last == -1) {
            return A
        }
        for (j in A.lastIndex downTo last) {
            if (A[j] < A[last]) {
                swap(j, last)
                return A
            }
        }

        swap(last - 1, last)
        return A
    }
}