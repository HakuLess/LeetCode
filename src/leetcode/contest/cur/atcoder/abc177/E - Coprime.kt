package leetcode.contest.cur.atcoder.abc177

import leetcode.contest.utils.gcd
import leetcode.contest.utils.lcm

// todo check
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(' ').map { it.toLong() }
    val mod = 1000000007L
    var product = 1L
    arr.forEach {
        product *= it
        product %= mod
    }
    var ans = 1L
    for (i in arr.indices) {
        ans = lcm(ans, arr[i])
        ans %= mod
    }
    if (ans == product) {
        println("pairwise coprime")
        return
    }
    var result = 0L
    for (element in arr) {
        result = gcd(result, element)
        if (result == 1L) {
            println("setwise coprime")
            return
        }
    }
    println("not coprime")
}