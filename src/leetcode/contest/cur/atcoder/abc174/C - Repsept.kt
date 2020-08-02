package leetcode.contest.cur.atcoder.abc174

fun main(args: Array<String>) {
    val k = readLine()!!.toInt()
    if (k % 2 == 0 || k % 5 == 0) {
        println(-1)
    }
    var cur = 7 % k
    var ans = 1
    while (cur != 0) {
        cur = cur * 10 + 7
        cur %= k
        ans++
    }
    println(ans)
}