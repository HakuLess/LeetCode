package leetcode.contest.last.c138

import leetcode.print

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
                swap(A, j, last)
                return A
            }
        }

        swap(A, last - 1, last)
        return A
    }

    fun swap(A: IntArray, index1: Int, index2: Int) {
        val temp = A[index1]
        A[index1] = A[index2]
        A[index2] = temp
    }
}