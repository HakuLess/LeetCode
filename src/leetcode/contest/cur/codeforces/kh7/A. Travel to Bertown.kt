package leetcode.contest.cur.codeforces.kh7

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (n, k) = readLine()!!.split(" ").map { it.toInt() }
        var ans = 0
        repeat(n) {
            val (l, r) = readLine()!!.split(" ").map { it.toInt() }
            if (k in l..r) {
                ans = maxOf(ans, r - k + 1)
            }
        }
        println(ans)
    }
}