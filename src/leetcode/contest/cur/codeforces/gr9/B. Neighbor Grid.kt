package leetcode.contest.cur.codeforces.gr9

import leetcode.contest.utils.print
import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        val dp = Array<IntArray>(n) { IntArray(m) }
        for (j in 0 until n) {
            val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
            dp[j] = array
        }
//        dp.print()
        var ava = true
        for (r in 0 until n) {
            for (c in 0 until m) {
                var max = 4
                if (r == 0 || r == n - 1) max--
                if (c == 0 || c == m - 1) max--
                if (dp[r][c] > max) {
                    ava = false
                }
            }
        }
        if (!ava) {
            println("NO")
            continue
        }

        for (r in 0 until n) {
            for (c in 0 until m) {
                var max = 4
                if (r == 0 || r == n - 1) max--
                if (c == 0 || c == m - 1) max--
                dp[r][c] = max
            }
        }
        println("YES")
        dp.forEach {
            println(it.joinToString(" "))
        }
    }
}