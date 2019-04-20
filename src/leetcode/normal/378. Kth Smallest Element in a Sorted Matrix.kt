package leetcode.normal

import leetcode.print

// todo not finish
fun main(args: Array<String>) {
    val s = Solution378()
    s.kthSmallest(
            arrayOf(
                    intArrayOf(1, 5, 9),
                    intArrayOf(10, 11, 13),
                    intArrayOf(12, 13, 15)
            ), 8
    ).print()
}

class Solution378 {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        var n = 0
        for (i in 0 until matrix.size) {
            if ((i + 1) * (i + 1) >= k) {
                n = i
            }
        }

        if ((n + 1) * (n + 1) == k) {
            return matrix[n][n]
        }

        var x = 0
        var y = 0
        for (i in 0 until k - n * n - 1) {
            println("POS: $x, $y")
            if (x == matrix.size - 1) {
                y++
                continue
            }
            if (y == matrix.size - 1) {
                x++
                continue
            }
            println("${matrix[x][n]}, ${matrix[n][y]}, $x, $y")
            if (matrix[x][n] <= matrix[n][y]) {
                x++
            } else {
                y++
            }
        }

        println("${matrix[x][n]}, ${matrix[n][y]}, $x, $y")
        return minOf(matrix[x][n], matrix[n][y])
    }
}