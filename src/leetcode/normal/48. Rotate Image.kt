package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val a = Solution48()
    a.rotate(arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
    ))
}

class Solution48 {

    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for (i in 0 until (n + 1) / 2) {
            for (j in 0 until n / 2) {
                val temp = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1]
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = matrix[i][j]
                matrix[i][j] = temp
            }
        }
    }

//    fun rotate(matrix: Array<IntArray>): Unit {
//        val n = matrix.size
//
//        for (i in 0 until n) {
//            for (j in 0 until n) {
//                if (i + j < n) {
//                    swap(matrix, i, j, n - j - 1, n - i - 1)
//                }
//            }
//        }
//        for (i in 0 until n / 2) {
//            swap(matrix, i, n - i - 1)
//        }
////        matrix.print()
//    }
//
//    private fun swap(matrix: Array<IntArray>, x1: Int, y1: Int, x2: Int, y2: Int) {
//        val temp = matrix[x1][y1]
//        matrix[x1][y1] = matrix[x2][y2]
//        matrix[x2][y2] = temp
//    }
//
//    private fun swap(matrix: Array<IntArray>, r1: Int, r2: Int) {
//        val temp = matrix[r1]
//        matrix[r1] = matrix[r2]
//        matrix[r2] = temp
//    }
}