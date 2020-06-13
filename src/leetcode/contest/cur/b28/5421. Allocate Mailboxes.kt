package leetcode.contest.cur.b28

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5421()
//    s.minDistance(intArrayOf(1, 4, 8, 10, 20), 3).print()
//    s.minDistance(intArrayOf(1, 8, 12, 10, 3), 3).print()
    s.minDistance(intArrayOf(5, 18, 25, 27, 28, 13, 9, 12, 22), 7).print()
}

class Solution5421 {

    fun minDistance(houses: IntArray, m: Int): Int {
        houses.sort()
        if (m >= houses.size) {
            return 0
        }
        val a = IntArray(houses.size + 1) { 400 }
        for (i in houses.indices) {
            a[i + 1] = houses[i]
        }

        fun data(x: Int, y: Int): Int {
            if (x == y) return 0
            val mid = (x + y) shr 1
            var sum = 0
            for (i in x..y) {
                sum += abs(a[i] - a[mid])
            }
            return sum
        }

        val f = Array<IntArray>(200) { IntArray(200) { 300 } }
        val n = houses.size
        for (i in 1..n) {
            f[i][1] = data(1, i)
        }

        for (i in 1..n) {
            for (j in 1..m) {
                for (k in 0..i - 1) {
                    f[i][j] = minOf(f[i][j], f[k][j - 1] + data(k + 1, i))
                }
            }
        }
        f.print()
        return f[n][m]
    }
}