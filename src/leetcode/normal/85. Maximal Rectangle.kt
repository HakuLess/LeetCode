package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution85()
    s.maximalRectangle(arrayOf(
            charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0')
    )).print()
}

class Solution85 {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val m: Int = matrix.size
        if (m == 0) {
            return 0
        }
        val n: Int = matrix[0].size
        val left = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (if (j == 0) 0 else left[i][j - 1]) + 1
                }
            }
        }

        var ret = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == '0') {
                    continue
                }
                var width = left[i][j]
                var area = width
                for (k in i - 1 downTo 0) {
                    width = minOf(width, left[k][j])
                    area = maxOf(area, (i - k + 1) * width)
                }
                ret = maxOf(ret, area)
            }
        }
        return ret
    }
}