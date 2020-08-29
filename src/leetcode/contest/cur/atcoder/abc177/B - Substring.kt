package leetcode.contest.cur.atcoder.abc177

fun main(args: Array<String>) {
    val s = readLine()!!.toString()
    val t = readLine()!!.toString()

    var ans = Int.MAX_VALUE
    for (i in s.indices) {
        if (t.length + i > s.length) break
        var temp = 0
        for (j in t.indices) {
            if (s[i + j] == t[j]) {
                continue
            } else {
                temp++
            }
        }
        ans = minOf(ans, temp)
    }
    println(ans)
}