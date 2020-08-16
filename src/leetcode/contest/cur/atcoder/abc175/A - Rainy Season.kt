package leetcode.contest.cur.atcoder.abc175

fun main(args: Array<String>) {
    val s = readLine()!!.toString()
    var cur = 0
    var ans = 0
    s.forEach {
        if (it == 'R') {
            cur++
        } else {
            cur = 0
        }
        ans = maxOf(ans, cur)
    }
    println(ans)
}