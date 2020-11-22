package leetcode.contest.cur.atcoder.abc184

fun main(args: Array<String>) {
    var (n, x) = readLine()!!.split(' ').map { it.toLong() }
    val s = readLine()!!.toString()
    for (i in s.indices) {
        if (s[i] == 'o') {
            x++
        } else {
            x--
        }
        if (x < 0) {
            println(0)
            return
        }
    }
    println(x)
}