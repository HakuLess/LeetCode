package leetcode.contest.cur.codeforces.cf678

fun main(args: Array<String>) {
    var (n, x, pos) = readLine()!!.split(" ").map { it.toInt() }
    n--
    var ans = n.toBigInteger()
    while (n > 1) {
        ans *= (n - 1).toBigInteger()
        ans %= 1000000007L.toBigInteger()
        n--
    }
    println(ans)
}