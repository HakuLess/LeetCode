package leetcode.contest.cur.codeforces.ecr94

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(' ').map { it.toInt() }
    var ans = if (arr[0] == 0) 0 else 1
    for (i in arr.indices) {
        if (i == 0) continue
        ans += maxOf(0, if (arr[i] - arr[i - 1] > 0) 1 else 0)
    }
    println(ans)
}