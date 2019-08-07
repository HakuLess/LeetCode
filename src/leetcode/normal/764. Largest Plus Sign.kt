package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution784()
    s.orderOfLargestPlusSign(5, arrayOf(intArrayOf(0, 1))).print()
}

class Solution784 {
    fun orderOfLargestPlusSign(N: Int, mines: Array<IntArray>): Int {
        val matrix = Array(N) { IntArray(N) { 1 } }
        mines.forEach {
            matrix[it[0]][it[1]] = 0
        }

        val a = Array(N) { IntArray(N) { 0 } }
        for (i in 0 until N) {
            var sum = 0
            for (j in 0 until N) {
                if (matrix[i][j] == 1) {
                    sum += 1
                } else {
                    sum = 0
                }
                a[i][j] = sum
            }
        }

        val b = Array(N) { IntArray(N) { 0 } }
        for (i in N - 1 downTo 0) {
            var sum = 0
            for (j in N - 1 downTo 0) {
                if (matrix[i][j] == 1) {
                    sum += 1
                } else {
                    sum = 0
                }
                b[i][j] = sum
            }
        }

        val c = Array(N) { IntArray(N) { 0 } }
        for (i in N - 1 downTo 0) {
            var sum = 0
            for (j in 0 until N) {
                if (matrix[j][i] == 1) {
                    sum += 1
                } else {
                    sum = 0
                }
                c[j][i] = sum
            }
        }

        val d = Array(N) { IntArray(N) { 0 } }
        for (i in N - 1 downTo 0) {
            var sum = 0
            for (j in N - 1 downTo 0) {
                if (matrix[j][i] == 1) {
                    sum += 1
                } else {
                    sum = 0
                }
                d[j][i] = sum
            }
        }

        a.print()
        b.print()
        c.print()
        d.print()

        var ans = 0
        for (i in 0 until N) {
            for (j in 0 until N) {
                var temp = minOf(a[i][j], b[i][j])
                temp = minOf(temp, c[i][j])
                temp = minOf(temp, d[i][j])
                ans = maxOf(ans, temp)
            }
        }
        return ans
    }
}