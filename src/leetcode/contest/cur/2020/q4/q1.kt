package leetcode.contest.cur.`2020`.q4

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solutionq1()
    s.paintingPlan(2, 2).print()
    s.paintingPlan(2, 1).print()
    s.paintingPlan(2, 4).print()
    s.paintingPlan(6, 11).print()
}

class Solutionq1 {
    fun paintingPlan(n: Int, k: Int): Int {
        if (k == n * n) return 1
        var ans = 0
        for (a in 0..n) {
            for (b in 0..n) {
                if ((a * n) + b * (n - a) == k) {
                    ans += comb(n, a) * comb(n, b)
                }
            }
        }
        return ans
    }

    fun comb(m: Int, n: Int): Int {
        var a = 1
        var b = 1
        var result = 1
        val qc = minOf(n, m - n)
        for (j in 0 until qc) {
            a *= (m - j)
            b *= (qc - j)
        }
        result = a / b
        return result
    }
}