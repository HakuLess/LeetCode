package leetcode.contest.cur.codeforces.gr9

import leetcode.contest.utils.print
import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val n = readLine()!!.toInt()
        val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        val dp = IntArray(n + 1) { 0 }
        array.forEach {
            dp[it] += 1
        }
        val ans = arrayListOf<Int>()
        while (true) {
            val cur = dp.indexOfFirst { it == 0 }
            if (cur == n) break
            else {
                ans.add(cur)
                dp[array[cur]]--
                dp[cur]++
                array[cur] = cur
            }
        }
        var j = 0
        while (j < array.size) {
            if (array[j] != j) {
                if (dp[j] == 0) {
                    ans.add(j)
                    dp[j]++
                    dp[array[j]]--
                    array[j] = j
                } else {
                    for (c in array.indices) {
                        if (array[c] == j) {
                            array[c] = dp.indexOfFirst { it == 0 }
                            dp[j]--
                            dp[array[c]]++
                            ans.add(c)
                        }
                    }
                }
            }
            if (array[j] == j) {
                j++
            }
        }
//        array.print()
        println(ans.size)
        println(ans.map { it + 1 }.joinToString(" "))
    }
}