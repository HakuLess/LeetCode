package leetcode.contest.cur.atcoder.abc174

import java.math.BigInteger

fun main(args: Array<String>) {
    val k = readLine()!!.toInt()
    val str = readLine()!!.toString()
    var l = 0
    var r = k - 1
    var ans = 0
    while (l < r) {
        while (str[l] == 'R') {
            l++
            if (l !in str.indices) {
                println(ans)
                return
            }
        }
        while (str[r] == 'W') {
            r--
            if (r !in str.indices) {
                println(ans)
                return
            }
        }
        if (l < r) {
            ans++
            l++
            r--
        }
    }
    println(ans)
}